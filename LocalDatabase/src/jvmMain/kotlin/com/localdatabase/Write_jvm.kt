package com.localdatabase

import com.domain.LoginLogic.WriteLogicContract
import java.sql.Connection
import java.sql.DriverManager

class Write_jvm: WriteLogicContract {
    override fun execute(name: String?,roll: Int?) {
         val d1: String?=name?.uppercase()?.replace(" ","")
         val d2: String?=roll?.toString()?.replace(" ","")
        var connection: Connection? = null


        try {
            connection = DriverManager.getConnection("jdbc:sqlite:credential.db")


            val sql = "INSERT OR REPLACE INTO credential VALUES (1, ?, ?);"
            val statement = connection.prepareStatement(sql)
            statement.setString(1, d1)
            statement.setString(2, d2)

            val rowsAffected = statement.executeUpdate()

            if (rowsAffected > 0) {
                println("Credentials saved successfully")
            } else {
                println("Write failed: No rows affected")
            }
        } catch (e: Exception) {
            println("Database error: ${e.message}")
        } finally {
            connection?.close()
        }


    }

}