package com.example.myapplication.domain.usecase

import com.example.myapplication.domain.data_interfaces.RemoteRepository

class ImageUseCase(private val remoteRepository: RemoteRepository) {
    suspend operator fun invoke(): String? {
        val result=remoteRepository.getAllImage()
        if (result.isSuccessful){
            return result.body()?.url
        }

        return result.errorBody()?.string()
    }
}