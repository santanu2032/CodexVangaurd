package com.Presentation.CommonUI.Event.Event_II

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.domain.AI.Output.SpeechEngine

@Composable
actual fun rememberSpeechEngine(): SpeechEngine {
    val context = LocalContext.current
    return remember { AndroidSpeechEngine(context) }
}