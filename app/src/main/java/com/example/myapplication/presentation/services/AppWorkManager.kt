package com.example.myapplication.presentation.services

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.myapplication.data.entities.DataEntity
import com.example.myapplication.domain.data_interfaces.LocalRepository
import com.example.myapplication.domain.data_interfaces.RemoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class AppWorkManager(
    appContext: Context, params: WorkerParameters, private val remoteRepository: RemoteRepository,
    private val localRepository: LocalRepository
) : CoroutineWorker(appContext, params) {
    override suspend fun doWork(): Result {
        return try {
            localRepository.deleteAllDataFromDatabase()
            val dataApiService = withContext(Dispatchers.IO) { remoteRepository.getAllData() }
            dataApiService.body()?.let {
                it.nearEarthObject?.values?.forEach { result ->
                localRepository.insertOrUpdateUser(result.map { it.convertToDataEntity()} as MutableList<DataEntity>).toMutableList()
            }
            }
            Result.success()

        } catch (exception: HttpException) {
            Result.failure()
        }
    }
}