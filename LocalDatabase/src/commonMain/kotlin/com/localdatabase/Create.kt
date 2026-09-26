package com.localdatabase
fun createTable() {
    val sql = """
        CREATE TABLE IF NOT EXISTS credential (
            roll_number INTEGER PRIMARY KEY,
            name TEXT NOT NULL
        );
    """.trimIndent()
}
