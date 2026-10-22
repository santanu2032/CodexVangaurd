package com.Presentation.CommonUI.Event.Event_II

import android.content.Context
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import com.domain.AI.Output.SpeechEngine
import kotlinx.coroutines.flow.*
import java.util.Locale
import java.util.concurrent.atomic.AtomicInteger

class AndroidSpeechEngine(context: Context) : SpeechEngine {

    private val _speaking = MutableStateFlow(false)
    override val isSpeaking: StateFlow<Boolean> = _speaking.asStateFlow()

    private val queued = AtomicInteger(0)
    private var tts: TextToSpeech? = null
    private var ready = false
    private var pending: String? = null

    init {
        tts = TextToSpeech(context.applicationContext) { status ->
            if (status != TextToSpeech.SUCCESS) return@TextToSpeech
            val r = tts?.setLanguage(Locale.US)
            ready = r != TextToSpeech.LANG_MISSING_DATA && r != TextToSpeech.LANG_NOT_SUPPORTED
            tts?.setSpeechRate(0.8f)
            tts?.setPitch(1.0f)


            tts?.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
                override fun onStart(id: String?) { _speaking.value = true }
                override fun onDone(id: String?) { finishOne() }
                @Deprecated("Deprecated in Java")
                override fun onError(id: String?) { finishOne() }
                override fun onStop(id: String?, interrupted: Boolean) { finishOne() }
            })
            if (ready) pending?.let { speak(it) }
            pending = null
        }
    }

    private fun finishOne() {
        if (queued.decrementAndGet() <= 0) {
            queued.set(0)
            _speaking.value = false
        }
    }

    override fun speak(text: String) {
        if (text.isBlank()) return
        if (!ready) { pending = text; return }
        stop()
        text.chunked(3500).forEachIndexed { i, chunk ->
            queued.incrementAndGet()
            tts?.speak(
                chunk,
                if (i == 0) TextToSpeech.QUEUE_FLUSH else TextToSpeech.QUEUE_ADD,
                null,
                "utt-${System.nanoTime()}"
            )
        }
    }

    override fun stop() {
        tts?.stop()
        queued.set(0)
        _speaking.value = false
    }

    override fun shutdown() {
        stop()
        tts?.shutdown()
        tts = null
        ready = false
    }
}