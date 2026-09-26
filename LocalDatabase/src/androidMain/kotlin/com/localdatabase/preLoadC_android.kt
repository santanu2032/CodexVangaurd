package com.localdatabase

import com.domain.LoginLogic.ReadID
import java.sql.DriverManager

class preLoadC_android : ReadID {


    override fun ReadId(): Array<String>? {
        var d1: String = ""
        var d2: String = ""
        var d: Array<String>? = null

        try {
            val connection = DriverManager.getConnection("jdbc:sqlite:credential.db")
            val sql: String = "SELECT * FROM credential WHERE id=1;"//TODO("add the read")
            val statement = connection.prepareStatement(sql)
            val result = statement.executeQuery()

            if (result.next()) {

                d1 = result.getString(2)
                d2 = result.getString(3)
                d = arrayOf(d1, d2)
            } else {
                println("id does not found")
            }
        } catch (e: Exception) {
            println(e.message)
        } finally {

        }
        return d
    }
}
