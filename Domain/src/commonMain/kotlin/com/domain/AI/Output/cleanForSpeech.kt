package com.domain.AI.Output


fun cleanForSpeech(raw: String): String =
    raw
        .replace(Regex("```[\\s\\S]*?```"), " code block omitted ")
        .replace(Regex("[*_`#>]"), "")
        .replace(Regex("[^\\p{L}\\p{N}\\p{P}\\p{Z}]"), "")
        .replace(Regex("\\s+"), " ")
        .trim()