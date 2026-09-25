package com.domain

class RequestRepository: RequestReprositoryRouter {
  override  suspend fun processRequest(str: String): String{

        return "\n Access Granted"
    }
}