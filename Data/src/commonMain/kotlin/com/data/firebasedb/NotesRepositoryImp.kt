package com.data.firebasedb

import kotlinx.coroutines.flow.Flow
import com.domain.firebase_db.Note
interface NotesRepository {
    fun getNotes(): Flow<List<Note>>
    suspend fun publishNote(title: String, subject: String, fileName: String, pdfBytes: ByteArray): Result<Unit>
}