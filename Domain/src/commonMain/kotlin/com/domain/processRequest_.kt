package com.domain

import com.domain.firebase_db.RemoteNotesDataSource

class processRequest_(private val dataSource: RemoteNotesDataSource): RequestReprositoryRouter {
  override  suspend fun processRequest(str: String): String{

      val result=dataSource.uploadPdfAndSaveToCloud(
          id = str,
          subject = str,
          fileName = "$str.pdf",
          pdfBytes = ByteArray(0)
      )
        return "\n Access Granted $result"
    }
}