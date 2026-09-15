package com.localdatabase

import com.localdatabase.CRUD_Contract.delete

class DatabaseDeleter: delete {

   override fun delete_(var_id: Int): String {

        return "DELETE FROM localdatabase WHERE id=$var_id;"
    }


   override fun deleteAll(): String {
        return "DELETE FROM localdatabase;"
    }
}