package com.localdatabase

import com.localdatabase.CRUD_Contract.write


class DatabaseWriter : write {

    override fun _write(id: Int, time_stamp: Long, column_1: String): String {
        return "INSERT INTO localdatabase(id,time_stamp,column_1) VALUES($id, $time_stamp, '$column_1');"
    }
}