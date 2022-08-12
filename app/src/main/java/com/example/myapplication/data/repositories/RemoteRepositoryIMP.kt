package com.example.myapplication.data.repositories


import com.example.myapplication.data.remote.ServiceAPI
import com.example.myapplication.domain.data_interfaces.RemoteRepository
import com.example.myapplication.data.response.GetAPIResponse
import com.example.myapplication.data.response.ImageResponse
import com.example.myapplication.presentation.utils.Constant.APIkEY
import com.example.myapplication.presentation.utils.Constant.getEndDate
import com.example.myapplication.presentation.utils.Constant.getStartDate
import retrofit2.Response

class RemoteRepositoryIMP(private val api: ServiceAPI) : RemoteRepository {
    override suspend fun getAllData(): Response<GetAPIResponse> {
        return api.getAllData(getStartDate(), getEndDate(), APIkEY)
    }
    override suspend fun getAllImage(): Response<ImageResponse> {
        return api.getAllImage(APIkEY)
    }

}