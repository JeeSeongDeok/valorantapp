package com.example.valorant.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.valorant.model.Entity

@Dao
interface Dao {
    @Query("SELECT * FROM riotId")
    fun getAll(): List<Entity>

    @Insert
    fun insertAll(vararg contacts: Entity)

    @Delete
    fun delete(contacts: Entity)
}