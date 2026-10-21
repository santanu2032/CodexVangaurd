package com.localdatabase

import android.database.sqlite.SQLiteDatabase
import com.domain.LoginLogic.WriteLogicContract

class Write_android(private val dbPath: String) : WriteLogicContract {
    override fun execute(name: String?, roll: Int?) {
        val d1: String? = name?.uppercase()?.replace(" ", "")
        val d2: String? = roll?.toString()?.replace(" ", "")

        try {
            SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE).use { db ->
                val sql = "INSERT OR REPLACE INTO credential VALUES (1, ?, ?);"
                db.execSQL(sql, arrayOf(d1, d2))
                println("Credentials saved successfully")
            }
        } catch (e: Exception) {
            println("Database error: ${e.message}")
        }
    }
}