package com.domain.AI.UserInput

interface UserInputContract {
    fun setData(str: String?)
    fun getData(): String?
}

interface ContextClassifier {
    fun processInputData(text: String): ContextType
}

// ---------- DOMAIN: IntentResult.kt ----------
sealed interface IntentResult {
    data class Success(
        val reply: String,
        val context: ContextType
    ) : IntentResult

    data class Failure(
        val reason: String,
        val context: ContextType? = null
    ) : IntentResult
}
// ---------- DOMAIN: AiSpecialist.kt ----------
interface AiSpecialist {
    val handles: ContextType
    suspend fun ask(text: String): String
}