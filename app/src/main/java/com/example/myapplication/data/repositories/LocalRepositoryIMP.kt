package com.example.myapplication.data.repositories

import com.example.myapplication.data.dao.DataDao
import com.example.myapplication.data.entities.DataEntity
import com.example.myapplication.data.local.AppDatabase

import com.example.myapplication.domain.data_interfaces.LocalRepository


class LocalRepositoryIMP(private val db: AppDatabase) : LocalRepository {
    override suspend fun getAllDataFromDatabase(): MutableList<DataEntity> {
        return db.dao().getAllDataFromDatabase()
    }

    override suspend fun insertOrUpdateUser(data: MutableList<DataEntity>): MutableList<DataEntity> {
        db.dao().insertOrUpdateUser(data)
        return data
    }

    override suspend fun deleteAllDataFromDatabase() {
        db.dao().deleteAllDataFromDatabase()
    }

}