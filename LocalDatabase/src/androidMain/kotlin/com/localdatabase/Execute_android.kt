package com.localdatabase

import java.sql.DriverManager

fun execute(){
    val connection = DriverManager.getConnection("jdbc:sqlite:localdata.db")
    val sql:String="write()"//TODO fix it

    try {
        val statement = connection.prepareStatement(sql)
        statement.setString(1, "Admin User")
        statement.executeUpdate()

        println("Data written to the database!")
    }
    finally {

    }
}