package com.example.myapplication.domain.usecase

import com.example.myapplication.domain.data_interfaces.LocalRepository
import com.example.myapplication.domain.model.DataModel
import com.example.myapplication.presentation.utils.Constant

class LocalDayUseCase(private val localRepository: LocalRepository) {
    suspend operator fun invoke(): MutableList<DataModel> {
        val getDay = Constant.getStartDate()
        return localRepository.getTodayAsteroids(getDay).map { it.convertToDataModel() }
            .toMutableList()
    }
}