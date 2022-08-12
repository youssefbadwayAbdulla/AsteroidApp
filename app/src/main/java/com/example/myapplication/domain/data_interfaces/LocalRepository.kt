package com.example.myapplication.domain.data_interfaces

import com.example.myapplication.data.entities.DataEntity

interface LocalRepository {
    suspend fun getAllDataFromDatabase(): MutableList<DataEntity>
    suspend fun insertOrUpdateUser(data: MutableList<DataEntity>): MutableList<DataEntity>
    suspend fun deleteAllDataFromDatabase()
}