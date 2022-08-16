package com.example.myapplication.di

import android.app.Application
import android.util.Log
import androidx.room.Room
import com.example.myapplication.data.local.AppDatabase
import com.example.myapplication.data.remote.ServiceAPI
import com.example.myapplication.data.repositories.LocalRepositoryIMP
import com.example.myapplication.data.repositories.RemoteRepositoryIMP
import com.example.myapplication.domain.data_interfaces.LocalRepository
import com.example.myapplication.domain.data_interfaces.RemoteRepository
import com.example.myapplication.domain.usecase.DataUseCase
import com.example.myapplication.domain.usecase.ImageUseCase
import com.example.myapplication.domain.usecase.LocalDayUseCase
import com.example.myapplication.domain.usecase.LocalWeekUseCase
import com.example.myapplication.presentation.services.AppWorkManager
import com.example.myapplication.presentation.ui.home.HomeViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.workmanager.dsl.worker
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://api.nasa.gov/"

val viewModelModule = module {

    viewModel {
        HomeViewModel(
            dataUseCase = get(),
            imageUseCase = get(),
            localDayUseCase = get(),
            localWeekUseCase = get()
        )
    }
}
val repositoryModel: Module = module {
    single<LocalRepository> { LocalRepositoryIMP(db = get()) }
    single<RemoteRepository> { RemoteRepositoryIMP(api = get()) }
    worker {
        AppWorkManager(
            remoteRepository = get(),
            localRepository = get(),
            appContext = get(),
            params = get()
        )
    }
    single { DataUseCase(remoteRepository = get(), localRepository = get()) }
    single { ImageUseCase(remoteRepository = get()) }
    single { LocalDayUseCase(localRepository = get()) }
    single { LocalWeekUseCase(localRepository = get()) }
}

// this part is Retrofit API.....................
val serviceAPIModule: Module = module {
    fun getRetroBuilder(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
    single { getRetroBuilder() }
    Log.d("AppModel", "${getRetroBuilder()}")
    fun getAPIServicesInstance(retrofit: Retrofit): ServiceAPI {
        Log.d("AppModel", "${retrofit.create(ServiceAPI::class.java)}")

        return retrofit.create(ServiceAPI::class.java)
    }
    single { getAPIServicesInstance(retrofit = get()) }
}

//this part is database.............
val databaseModel: Module = module {
    fun getDatabaseInstance(application: Application): AppDatabase {
        return Room.databaseBuilder(
            application,
            AppDatabase::class.java, "user_database"
        ).fallbackToDestructiveMigration().build()
    }
    single { getDatabaseInstance(androidApplication()) }
}
