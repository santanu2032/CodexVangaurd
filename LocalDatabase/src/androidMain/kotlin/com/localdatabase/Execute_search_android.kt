package com.localdatabase

import com.domain.LoginLogic.searchContract
import java.sql.Connection
import java.sql.DriverManager

class Execute_search_android: searchContract {

    override fun search(roll: Int?): Array<String>?{
        var connection: Connection? = null
        val sql = "SELECT * FROM studentRecord WHERE roll_number = $roll;"

        var d1 = ""
        var d2 = ""
        var d: Array<String>? = null

        try {
            connection = DriverManager.getConnection("jdbc:sqlite:studentRecord.db")
            val statement = connection.prepareStatement(sql)
            val result = statement.executeQuery()

            if (result.next()) {
                d1 = result.getInt(1).toString()
                d2 = result.getString(2)
                d = arrayOf(d1, d2)
            } else {
                println("Roll number $roll not found")
            }
        } catch (e: Exception) {
            println("Database error: ${e.message}")
        } finally {
            connection?.close()
        }

        return d
    }
}