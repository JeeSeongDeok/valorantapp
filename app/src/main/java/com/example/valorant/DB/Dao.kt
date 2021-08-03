package com.example.valorant.DB

import android.provider.ContactsContract
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.valorant.data.Entity

@Dao
interface Dao {
    @Query("SELECT * FROM riotId")
    fun getAll(): List<Entity>

    @Insert
    fun insertAll(vararg contacts: Entity)

    @Delete
    fun delete(contacts:Entity)
}