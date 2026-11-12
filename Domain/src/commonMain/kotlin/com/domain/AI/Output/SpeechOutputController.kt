package com.domain.AI.Output


import kotlinx.coroutines.flow.*

class SpeechOutputController(private val engine: SpeechEngine) {

    private val _enabled = MutableStateFlow(true)
    val enabled: StateFlow<Boolean> = _enabled.asStateFlow()
    val isSpeaking: StateFlow<Boolean> = engine.isSpeaking

    fun speakReply(text: String) {
        if (_enabled.value) engine.speak(cleanForSpeech(text))
    }

    fun toggle() = setEnabled(!_enabled.value)

    fun setEnabled(value: Boolean) {
        _enabled.value = value
        if (!value) engine.stop()
    }

    fun stop() = engine.stop()
    fun release() = engine.shutdown()
}