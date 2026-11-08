package com.domain.AI.UserInput

class KeywordContextClassifier:ContextClassifier {
    private val keywords: Map<ContextType, Set<String>> = mapOf(
        ContextType.CODING to setOf(
            "code", "kotlin", "java", "python", "function", "class", "variable",
            "bug", "error", "exception", "crash", "compile", "gradle", "api",
            "compose", "android", "lateinit", "debug", "algorithm", "interface"
        ),
        ContextType.MATH to setOf(
            "calculate", "solve", "equation", "integral", "derivative",
            "sum", "percentage", "probability", "matrix", "algebra"
        )
    )

    private val codePatterns = listOf(
        Regex("```"),
        Regex("""\b(fun|val|var|def|class)\s+\w+"""),
        Regex("""\w+\(.*\)\s*[{;]?"""),
        Regex("""[{};]{2,}""")
    )

    private val mathPattern = Regex("""\d+\s*[-+*/^=]\s*\d+""")



    override fun processInputData(text: String): ContextType {
        val cleaned = text.trim().lowercase()
        if (cleaned.isEmpty()) return ContextType.GENERAL


        val words = cleaned.split(Regex("[^a-z0-9_]+")).filter { it.isNotEmpty() }.toSet()

        val scores = mutableMapOf<ContextType, Int>()


        for ((type, set) in keywords) {
            scores[type] = words.count { it in set }
        }


        if (codePatterns.any { it.containsMatchIn(cleaned) }) {
            scores[ContextType.CODING] = (scores[ContextType.CODING] ?: 0) + 2
        }
        if (mathPattern.containsMatchIn(cleaned)) {
            scores[ContextType.MATH] = (scores[ContextType.MATH] ?: 0) + 2
        }


        val best = scores.maxByOrNull { it.value }
        return if (best == null || best.value == 0) ContextType.GENERAL else best.key
    }
}