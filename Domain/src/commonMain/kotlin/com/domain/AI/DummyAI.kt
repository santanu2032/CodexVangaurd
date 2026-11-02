package com.domain.AI

import com.domain.AI.UserInput.AiSpecialist
import com.domain.AI.UserInput.ContextType

class EchoSpecialist(override val handles: ContextType) : AiSpecialist {
    override suspend fun ask(text: String): String =
        "[${handles.name}] You said: $text"
}