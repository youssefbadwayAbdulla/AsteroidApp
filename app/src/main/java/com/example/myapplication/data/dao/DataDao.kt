package com.example.myapplication.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.data.entities.DataEntity

@Dao
interface DataDao {
    @Query("SELECT * FROM  data_entity")
    suspend fun getAllDataFromDatabase(): MutableList<DataEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateUser(data: MutableList<DataEntity>)

    @Query("DELETE FROM data_entity")
    suspend fun deleteAllDataFromDatabase()
}