package com.network

import com.network.firebase_db.RemoteNotesDataSource

class processRequest_(private val dataSource: RemoteNotesDataSource): RequestReprositoryRouter {
  @Suppress("SuspiciousIndentation")
  override  suspend fun processRequest(str: String,type: String): String{

      val result=dataSource.uploadPdfAndSaveToCloud(
          id = "Admin",
          subject = type,
          fileName = str,
          pdfBytes = ByteArray(0)
      )
        return "\n Access Granted $result"
    }
}