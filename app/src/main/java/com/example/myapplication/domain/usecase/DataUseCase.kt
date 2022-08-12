package com.example.myapplication.domain.usecase

import com.example.myapplication.data.repositories.RemoteRepositoryIMP
import com.example.myapplication.domain.data_interfaces.LocalRepository
import com.example.myapplication.domain.data_interfaces.RemoteRepository
import com.example.myapplication.domain.model.DataModel

class DataUseCase(private val remoteRepository: RemoteRepository,private val localRepository: LocalRepository ) {
    suspend operator fun invoke(): MutableList<DataModel> {
        val result =
            localRepository.getAllDataFromDatabase().map { it.convertToDataModel() }.toMutableList()
        if (result.isEmpty()) {
            remoteRepository.getAllData().body()?.let {
                it.nearEarthObject?.values?.forEach { list ->
                    result.addAll(localRepository.insertOrUpdateUser(list.map { it.convertToDataEntity() }
                        .toMutableList()).map { it.convertToDataModel() }.toMutableList())
                }
            }
        }
        return result
    }
}