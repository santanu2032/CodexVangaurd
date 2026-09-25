package com.domain.firebase_db

class RequestRepository: RequestReprositoryRouter {
  override  suspend fun processRequest(): String{

        return "\n Access Granted"
    }
}