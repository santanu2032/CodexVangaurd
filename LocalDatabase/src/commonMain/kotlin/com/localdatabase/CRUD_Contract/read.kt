package com.localdatabase.CRUD_Contract

interface read {
    fun read(var_id: Int): String
    fun readAll(): String
}