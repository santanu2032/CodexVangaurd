package com.localdatabase.CRUD_Contract

interface update {
    fun update_(var_id: Int, newData: String, newTimestamp: Long): String
}