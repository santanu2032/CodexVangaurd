package com.network.network_android

import com.network.firebase_db.Note
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