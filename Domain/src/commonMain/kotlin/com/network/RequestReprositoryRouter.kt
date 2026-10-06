package com.network

interface RequestReprositoryRouter {
    suspend fun processRequest(str: String,type: String): String
}