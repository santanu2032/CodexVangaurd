package com.localdatabase

import android.database.sqlite.SQLiteDatabase
import com.network.LoginLogic.searchContract

class Execute_search_android(private val dbPath: String) : searchContract {
    override fun search(roll: Int?): Array<String>? {
        if (roll == null) return null
        var d: Array<String>? = null

        try {
            SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READONLY).use { db ->
                val sql = "SELECT * FROM studentRecord WHERE roll_number = ?;"
                db.rawQuery(sql, arrayOf(roll.toString())).use { cursor ->
                    if (cursor.moveToFirst()) {
                        val d1 = cursor.getInt(0).toString() // Column 1 in JDBC
                        val d2 = cursor.getString(1)         // Column 2 in JDBC
                        d = arrayOf(d1, d2)
                    } else {
                        println("Roll number $roll not found")
                    }
                }
            }
        } catch (e: Exception) {
            println("Database error: ${e.message}")
        }
        return d
    }
}