package com.Presentation.CommonUI.Event.Event_II

import androidx.compose.runtime.Composable


actual class VoiceRecognizer {
    actual fun startListening(
        onResult: (String) -> Unit,
        onError: (String) -> Unit
    ) {
    }

    actual fun stopListening() {
    }

    actual fun destroy() {
    }
}

@Composable
actual fun rememberVoiceRecognizer(): VoiceRecognizer {
    TODO("Not yet implemented")
}