package com.example.myapplication.domain.data_interfaces

import com.example.myapplication.data.response.GetAPIResponse
import com.example.myapplication.data.response.ImageResponse
import retrofit2.Response

interface RemoteRepository {
    suspend fun getAllData(): Response<GetAPIResponse>
    suspend fun getAllImage(): Response<ImageResponse>

}