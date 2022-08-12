package com.example.myapplication.presentation.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.entities.DataEntity
import com.example.myapplication.domain.model.DataModel
import com.example.myapplication.domain.usecase.DataUseCase
import com.example.myapplication.domain.usecase.ImageUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(
    private val dataUseCase: DataUseCase,
    private val imageUseCase: ImageUseCase
) : ViewModel() {
    //Room
    private var dataMutableLiveData = MutableLiveData<MutableList<DataEntity>>()
    val dataLiveData: LiveData<MutableList<DataEntity>> get() = dataMutableLiveData

    //Retrofit
    private var dataAPIMutableLiveData = MutableLiveData<MutableList<DataModel>>()
    val dataAPILiveData: LiveData<MutableList<DataModel>> get() = dataAPIMutableLiveData

    //loading
    private val loadingMutableLiveData = MutableLiveData<Boolean>()
    val loadingLiveData: LiveData<Boolean> get() = loadingMutableLiveData

    //IMAGE
    private val imageMutableLiveData = MutableLiveData<String>()
    val imageLiveData: LiveData<String> get() = imageMutableLiveData

    fun getAPIAllData() = viewModelScope.launch {
        loadingMutableLiveData.postValue(true)
        val result = withContext(Dispatchers.IO) { dataUseCase() }
            dataAPIMutableLiveData.postValue(result)
            loadingMutableLiveData.postValue(false)

    }

    fun getAllImage() = viewModelScope.launch {
        val image = withContext(Dispatchers.IO) {
            imageUseCase()
        }

        imageMutableLiveData.postValue(image)

    }

}