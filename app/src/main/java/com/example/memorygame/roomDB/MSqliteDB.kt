package com.example.memorygame.roomDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(SkorModel::class), version = 1)
abstract class MSqliteDB : RoomDatabase(){
    //singleton
    abstract fun SkorDAO(): SkorDAO


    companion object {
        @Volatile
        private var instance: MSqliteDB? = null

        private val lock = Any()
        operator fun invoke(context: Context) = instance ?: synchronized(lock) {
            instance ?: makeDatabase(context).also {
                instance = it
            }
        }

        private fun makeDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            MSqliteDB::class.java,
            "skordatabase"
        ).build()
    }

}