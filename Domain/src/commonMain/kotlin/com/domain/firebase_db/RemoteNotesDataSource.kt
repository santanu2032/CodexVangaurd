package com.domain.firebase_db

import kotlinx.coroutines.flow.Flow
data class Note(
    val user_id: String = "",
    val id: String,
    val subject: String,
    val downloadUrl: String,
    val uploadedAt: Long = 0L
)

interface RemoteNotesDataSource {
    suspend fun uploadPdfAndSaveToCloud(
        id: String,
        subject: String,
        fileName: String,
        pdfBytes: ByteArray
    ): Result<Unit>

    fun observeNotesFromCloud(): Flow<List<Note>>
}