package com.domain.AI.UserInput


import kotlinx.coroutines.CancellationException

class IntentManager(
    private val classifier: ContextClassifier,
    specialists: List<AiSpecialist>
) {

    private val byContext: Map<ContextType, AiSpecialist> =
        specialists.associateBy { it.handles }

    init {
        require(byContext.containsKey(ContextType.GENERAL)) {
            "IntentManager needs a GENERAL specialist as the fallback"
        }
    }

    suspend fun handle(rawText: String): IntentResult {
        val text = rawText.trim()
        if (text.isEmpty()) {
            return IntentResult.Failure("Empty input")
        }


        val context = classifier.processInputData(text)


        val specialist = byContext[context] ?: byContext.getValue(ContextType.GENERAL)


        return try {
            IntentResult.Success(
                reply = specialist.ask(text),
                context = specialist.handles
            )
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            IntentResult.Failure(
                reason = e.message ?: "Specialist failed",
                context = specialist.handles
            )
        }
    }
}