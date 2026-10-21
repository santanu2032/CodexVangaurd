package com.Presentation.CommonUI.Event.Event_II

import androidx.compose.runtime.Composable

// NO Context here. commonMain doesn't need to know about it.
expect class VoiceRecognizer {
    // We only define empty methods here
    fun startListening(onResult: (String) -> Unit, onError: (String) -> Unit)
    fun stopListening()
    fun destroy()
}

// This Composable function is the bridge that will fetch the Context on Android
@Composable
expect fun rememberVoiceRecognizer(): VoiceRecognizer