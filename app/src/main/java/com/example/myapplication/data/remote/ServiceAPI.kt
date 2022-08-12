package com.example.myapplication.data.remote

import com.example.myapplication.data.response.GetAPIResponse
import com.example.myapplication.data.response.ImageResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceAPI {
    @GET("neo/rest/v1/feed")
    suspend fun getAllData(
        @Query("start_date") startDate: String,
        @Query("end_date") endDate: String,
        @Query("api_key") apiKey: String
    ): Response<GetAPIResponse>

    @GET("planetary/apod")
    suspend fun getAllImage(
        @Query("api_key") apiKey: String
    ): Response<ImageResponse>

}