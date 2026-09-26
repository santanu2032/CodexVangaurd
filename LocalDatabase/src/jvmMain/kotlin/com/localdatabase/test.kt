package com.localdatabase

import java.sql.DriverManager

fun main(){
    val sql = """
        CREATE TABLE IF NOT EXISTS studentRecord (
            roll_number INTEGER PRIMARY KEY,
            name TEXT NOT NULL
        );
    """.trimIndent()
    try {
        DriverManager.getConnection("jdbc:sqlite:studentRecord.db").use { connection ->
            connection.prepareStatement(sql).use { statement ->
                statement.executeUpdate()
                println("Table created successfully!")
            }
        }
    } catch (e: Exception) {
        println("Error creating table: ${e.message}")
    }
}