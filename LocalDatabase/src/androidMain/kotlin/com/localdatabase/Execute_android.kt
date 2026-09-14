package com.localdatabase

import java.sql.DriverManager
import com.localdatabase.write
fun execute(){
    val connection = DriverManager.getConnection("jdbc:sqlite:localdata.db")
    val sql:String=write()

    try {
        val statement = connection.prepareStatement(sql)
        statement.setString(1, "Admin User")
        statement.executeUpdate()

        println("Data written to the database!")
    }
    finally {

    }
}