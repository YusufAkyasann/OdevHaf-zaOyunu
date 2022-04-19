package com.example.memorygame.roomDB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface  SkorDAO {
    @Insert
    suspend fun insertAll(vararg skorModel: SkorModel):List<Long>

    @Query("select * from SkorModel")
    suspend fun getAllSkors():List<SkorModel>

    @Query("select * from SkorModel where uuid ==:pw_id")
    suspend fun getPassword(pw_id: Int): SkorModel
}