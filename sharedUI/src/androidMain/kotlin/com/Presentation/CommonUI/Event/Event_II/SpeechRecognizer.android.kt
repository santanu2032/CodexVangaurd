package com.Presentation.CommonUI.Event.Event_II

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import com.google.mlkit.genai.common.DownloadStatus
import com.google.mlkit.genai.common.FeatureStatus
import com.google.mlkit.genai.common.audio.AudioSource
import com.google.mlkit.genai.speechrecognition.SpeechRecognition
import com.google.mlkit.genai.speechrecognition.SpeechRecognizer
import com.google.mlkit.genai.speechrecognition.SpeechRecognizerOptions
import com.google.mlkit.genai.speechrecognition.SpeechRecognizerRequest
import com.google.mlkit.genai.speechrecognition.SpeechRecognizerResponse
import com.google.mlkit.genai.speechrecognition.speechRecognizerOptions
import com.google.mlkit.genai.speechrecognition.speechRecognizerRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import java.util.Locale

actual class VoiceRecognizer(private val context: Context) {
    private var speechRecognizer: SpeechRecognizer? = null
    private val scope = CoroutineScope(Dispatchers.Main)
    private var recognitionJob: Job? = null

    init {
        val options: SpeechRecognizerOptions = speechRecognizerOptions {
            locale = Locale.US
            preferredMode = SpeechRecognizerOptions.Mode.MODE_BASIC
        }
        speechRecognizer = SpeechRecognition.getClient(options)
    }

    actual fun startListening(onResult: (String) -> Unit, onError: (String) -> Unit) {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            onError("Microphone permission not granted")
            return
        }

        val recognizer = speechRecognizer ?: return

        scope.launch {
            val status: Int = recognizer.checkStatus()

            if (status == FeatureStatus.DOWNLOADABLE) {
                onError("Downloading speech model... Please wait.")

                recognizer.download().collect { downloadStatus ->
                    when (downloadStatus) {
                        is DownloadStatus.DownloadCompleted -> {
                            startMyRecognition(recognizer, onResult, onError)
                        }
                        is DownloadStatus.DownloadFailed -> {
                            onError("Failed to download speech model.")
                        }
                        is DownloadStatus.DownloadProgress -> {}
                        else -> {}
                    }
                }
            } else if (status == FeatureStatus.AVAILABLE) {
                startMyRecognition(recognizer, onResult, onError)
            } else {
                onError("Speech recognition unavailable on this device (Status: $status)")
            }
        }
    }

    private fun startMyRecognition(
        recognizer: SpeechRecognizer,
        onResult: (String) -> Unit,
        onError: (String) -> Unit
    ) {
        val request: SpeechRecognizerRequest = speechRecognizerRequest {
            audioSource = AudioSource.fromMic()
        }

        recognitionJob = scope.launch {
            try {
                recognizer.startRecognition(request).collect { response ->
                    when (response) {
                        is SpeechRecognizerResponse.PartialTextResponse -> {
                            onResult(response.text)
                        }
                        is SpeechRecognizerResponse.FinalTextResponse -> {
                            onResult(response.text)
                        }
                        is SpeechRecognizerResponse.ErrorResponse -> {
                            onError(response.toString())
                        }
                        is SpeechRecognizerResponse.CompletedResponse -> {}
                    }
                }
            } catch (e: Exception) {
                onError(e.localizedMessage ?: "Recognition error")
            }
        }
    }

    actual fun stopListening() {
        scope.launch {
            try {
                speechRecognizer?.stopRecognition()
            } catch (_: Exception) {}
        }
        recognitionJob?.cancel()
    }

    actual fun destroy() {
        recognitionJob?.cancel()
        val recognizer = speechRecognizer
        speechRecognizer = null
        scope.launch {
            try { recognizer?.stopRecognition() } catch (_: Exception) {}
            recognizer?.close()
            scope.cancel()
        }
    }
}

@Composable
actual fun rememberVoiceRecognizer(): VoiceRecognizer {
    val context = LocalContext.current
    return remember { VoiceRecognizer(context) }
}