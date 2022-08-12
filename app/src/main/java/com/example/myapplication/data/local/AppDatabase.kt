package com.example.myapplication.data.local


import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.data.dao.DataDao
import com.example.myapplication.data.entities.DataEntity

@Database(entities = [DataEntity::class], version = 1, exportSchema = false)
    abstract class AppDatabase : RoomDatabase() {
        abstract fun dao(): DataDao
    }
