package com.domain.AI

import com.domain.AI.UserInput.AiSpecialist
import com.domain.AI.UserInput.ContextType

class GeneralSpecialistAI(override val handles: ContextType): AiSpecialist {
    override suspend fun ask(text: String): String {
        val input = text.lowercase().trim()
        val words = input
            .replace(Regex("[^a-z0-9 ]"), " ")   // drop punctuation and emoji
            .split(" ")
            .filter { it.isNotEmpty() }

        if (words.isEmpty()) {
            return "Say something and I'll try to help. 🙂"
        }

        // Greetings
        if (words[0] == "hi" || words[0] == "hello" || words[0] == "hey" || words[0] == "namaste") {
            return "Hello! 👋 How can I help you?"
        }
        // Thanks
        else if ("thanks" in words || "thank" in words || "thx" in words) {
            return "You're welcome! 😊"
        }
        // Goodbye
        else if (words[0] == "bye" || words[0] == "goodbye") {
            return "Goodbye! 👋"
        }
        // Identity
        else if (input.contains("who are you") || input.contains("your name")) {
            return "I'm a rule-based assistant. Same question, same answer, every time. 🤖"
        }
        // How are you
        else if (input.contains("how are you")) {
            return "I'm running fine, thanks for asking! 😄"
        }
        // Help
        else if ("help" in words) {
            return "Try: hello, how are you, who are you, thanks, bye."
        }
        // Nothing matched
        else {
            return "I don't have an answer for that yet. 🤷 Type help to see what I can do."
        }
    }
}