package com.example.valorant.data.database.dto
import androidx.room.*
import androidx.room.Entity

@Entity(tableName = "riotId")
data class Entity(
    @PrimaryKey(autoGenerate = true) val id:Long,
    var name:String,
    var pw:String
)
