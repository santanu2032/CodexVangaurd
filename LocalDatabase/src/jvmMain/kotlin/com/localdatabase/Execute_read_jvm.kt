package com.localdatabase

import com.domain.LoginLogic.LoginContract
import java.sql.Connection
import java.sql.DriverManager

class Execute_read_jvm : LoginContract {
    override fun execute(): Array<String>? {
        var connection: Connection? = null
        var d1: String = ""
        var d2: String = ""
        var d: Array<String>? = null

        try {
            connection = DriverManager.getConnection("jdbc:sqlite:credential.db")
            val sql: String = "SELECT * FROM credential WHERE id=1;"
            val statement = connection.prepareStatement(sql)
            val result = statement.executeQuery()

            if (result.next()) {
                d1 = result.getString(2)
                d2 = result.getString(3)
                d = arrayOf(d1, d2)
            } else {
                println("id not found")
            }
        } catch (e: Exception) {
            println("Database error: ${e.message}")
        } finally {
            connection?.close()
        }

        return d
    }
}