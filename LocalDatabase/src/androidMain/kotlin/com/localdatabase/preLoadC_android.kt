package com.localdatabase

import android.database.sqlite.SQLiteDatabase
import com.network.LoginLogic.ReadID

class preLoadC_android(private val dbPath: String) : ReadID {
    override fun ReadId(): Array<String>? {
        var d: Array<String>? = null
        try {
            SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READONLY).use { db ->
                db.rawQuery("SELECT * FROM credential WHERE id=1;", null).use { cursor ->
                    if (cursor.moveToFirst()) {
                        val d1 = cursor.getString(1) // Column 2 in JDBC
                        val d2 = cursor.getString(2) // Column 3 in JDBC
                        d = arrayOf(d1, d2)
                    } else {
                        println("id does not found")
                    }
                }
            }
        } catch (e: Exception) {
            println("Preload DB error: ${e.message}")
        }
        return d
    }
}