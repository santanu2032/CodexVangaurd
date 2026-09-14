package com.localdatabase

import java.sql.DriverManager

fun execute_jvm() {
    val dbUrl = "jdbc:sqlite:LocalDatabase/localdatabase.db"

    try {
        DriverManager.getConnection(dbUrl).use { connection ->
            val sqlCommand = write()

            connection.createStatement().use { statement ->
                val rowsAffected = statement.executeUpdate(sqlCommand)
                println("Success! Rows inserted: $rowsAffected")
            }
        }
    } catch (e: Exception) {
        println("Database execution failed: ${e.message}")
        e.printStackTrace()
    }
}
fun main(){
    execute_jvm()
}