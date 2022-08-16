package com.example.myapplication.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.data.entities.DataEntity

@Dao
interface DataDao {
    @Query("SELECT * FROM  data_entity ORDER by date ASC ")
    suspend fun getAllDataFromDatabase():MutableList<DataEntity>

    @Query("SELECT * FROM data_entity WHERE date == :today ORDER by date ASC")
    suspend fun getTodayAsteroids(today: String) : MutableList<DataEntity>

    @Query("SELECT * FROM data_entity WHERE date <= :week ORDER by date ASC")
    suspend fun getWeekAsteroids(week: String) :MutableList<DataEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateUser(data: MutableList<DataEntity>)

    @Query("DELETE FROM data_entity")
    suspend fun deleteAllDataFromDatabase()
}