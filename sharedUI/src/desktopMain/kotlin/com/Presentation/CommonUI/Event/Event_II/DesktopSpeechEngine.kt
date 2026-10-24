package com.Presentation.CommonUI.Event.Event_II

import com.domain.AI.Output.SpeechEngine
import kotlinx.coroutines.flow.*

class DesktopSpeechEngine : SpeechEngine {
    private val _speaking = MutableStateFlow(false)
    override val isSpeaking: StateFlow<Boolean> = _speaking.asStateFlow()
    private var process: Process? = null

    override fun speak(text: String) {
        stop()
        if (text.isBlank()) return
        val safe = text.replace("'", "''")
        val script = "Add-Type -AssemblyName System.Speech; " +
                "(New-Object System.Speech.Synthesis.SpeechSynthesizer).Speak('$safe')"
        val p = ProcessBuilder("powershell", "-NoProfile", "-Command", script).start()
        process = p
        _speaking.value = true
        Thread { p.waitFor(); if (process === p) _speaking.value = false }.start()
    }

    override fun stop() { process?.destroy(); process = null; _speaking.value = false }
    override fun shutdown() = stop()
}