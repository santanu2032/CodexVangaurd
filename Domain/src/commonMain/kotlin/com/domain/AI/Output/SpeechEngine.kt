package com.domain.AI.Output

import kotlinx.coroutines.flow.StateFlow

interface SpeechEngine {
    val isSpeaking: StateFlow<Boolean>
    fun speak(text: String)
    fun stop()
    fun shutdown()
}