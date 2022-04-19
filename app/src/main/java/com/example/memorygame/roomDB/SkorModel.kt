package com.example.memorygame.roomDB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SkorModel(
    @ColumnInfo(name = "name")
    val name: String?,
    @ColumnInfo(name = "skor")
    val skor: String?
)
{
    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0
}