package com.domain.network_android

import com.domain.firebase_db.Note
import com.domain.firebase_db.RemoteNotesDataSource
import kotlinx.coroutines.flow.Flow

class FirebaseNetworkDataSource  {

     suspend fun uploadPdfAndSaveToCloud(
        id: String,
        subject: String,
        fileName: String,
        pdfBytes: ByteArray
    ): Result<Unit> {
        TODO("Not yet implemented")
    }

   fun observeNotesFromCloud(): Flow<List<Note>> {
        TODO("Not yet implemented")
    }
}