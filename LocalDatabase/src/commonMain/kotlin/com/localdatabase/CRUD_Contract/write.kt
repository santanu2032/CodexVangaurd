package com.localdatabase.CRUD_Contract

interface write {

    fun _write(id: Int,time_stamp: Long,column_1: String): String
}