package com.example.myapplication.domain.usecase

import android.util.Log
import com.example.myapplication.domain.data_interfaces.LocalRepository
import com.example.myapplication.domain.model.DataModel
import com.example.myapplication.presentation.utils.Constant

class LocalWeekUseCase(private val localRepository: LocalRepository) {
    suspend operator fun invoke(): MutableList<DataModel> {
        val getWeek = Constant.getEndDate()
        Log.i("viewModel", "invoke:$getWeek ")
        return localRepository.getWeekAsteroids(getWeek).map { it.convertToDataModel() }
            .toMutableList()
    }
}