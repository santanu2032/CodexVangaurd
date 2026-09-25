package com.domain

interface RequestReprositoryRouter {
    suspend fun processRequest(str: String): String
}