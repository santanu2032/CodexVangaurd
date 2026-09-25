package com.domain.network_android

import com.domain.firebase_db.RemoteNotesDataSource
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import com.domain.firebase_db.Note

class FirestoreNotesDataSource : RemoteNotesDataSource {

    // 1. Connect to Firestore and open the "notes" collection
    private val notesCollection = FirebaseFirestore.getInstance().collection("notes")

    // 2. SEND / UPDATE data in Firestore TODO("send and update")
    override suspend fun uploadPdfAndSaveToCloud(
        title: String,
        subject: String,
        fileName: String,
        pdfBytes: ByteArray
    ): Result<Unit> = withContext(Dispatchers.IO) {
        try {
            val data = hashMapOf(
                "title" to title,
                "subject" to subject,
                "fileName" to fileName,
                "uploadedAt" to System.currentTimeMillis()
            )

            // Sends the map to Firebase and waits for completion
            notesCollection.add(data).await()

            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    //  READ live data from Firestore TODO("read logic")
    override fun observeNotesFromCloud(): Flow<List<Note>> = callbackFlow {
        val listener = notesCollection.addSnapshotListener { snapshot, _ ->
            if (snapshot != null) {
                val notes = snapshot.documents.map { doc ->
                    Note(
                        id = doc.id,
                        title = doc.getString("title") ?: "",
                        subject = doc.getString("subject") ?: "",
                        downloadUrl = doc.getString("downloadUrl") ?: "",
                        uploadedAt = doc.getLong("uploadedAt") ?: 0L
                    )
                }
                trySend(notes)
            }
        }
        awaitClose { listener.remove() }
    }
}