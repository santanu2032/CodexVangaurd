package com.domain.firebase_db

interface RequestReprositoryRouter {
    suspend fun processRequest(): String
}