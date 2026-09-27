package com.localdatabase.helper

import android.content.Context

fun getWritableDbPath(context: Context, dbName: String): String {
    val dbFile = context.getDatabasePath(dbName)


    dbFile.parentFile?.mkdirs()


    if (!dbFile.exists()) {
        try {
            context.assets.open(dbName).use { input ->
                dbFile.outputStream().use { output ->
                    input.copyTo(output)
                }
            }
        } catch (e: Exception) {
            println("Asset copy skipped or failed for $dbName: ${e.message}")
        }
    }
    return dbFile.absolutePath
}