package com.localdatabase

import com.localdatabase.CRUD_Contract.update

class DatabaseUpdater: update{
  override  fun update_(var_id: Int, newData: String, newTimestamp: Long): String {
        return "UPDATE localdatabase SET column_1=\"$newData\", time_stamp=$newTimestamp WHERE id=$var_id;"
    }
}