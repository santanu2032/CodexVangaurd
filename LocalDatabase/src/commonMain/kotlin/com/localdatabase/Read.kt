package com.localdatabase

import com.localdatabase.CRUD_Contract.read
class DatabaseReader: read {
   override fun read(var_id: Int): String {

        return "SELECT * FROM credential WHERE id=$var_id;"
    }

 override   fun readAll(): String {

        return "SELECT * FROM credential;"
    }
}