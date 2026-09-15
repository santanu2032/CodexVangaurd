package com.localdatabase.CRUD_Contract

interface delete {
    fun delete_(var_id: Int): String
    fun deleteAll(): String
}