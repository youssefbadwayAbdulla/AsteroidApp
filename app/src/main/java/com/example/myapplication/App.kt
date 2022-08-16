package com.example.myapplication

import android.app.Application
import com.example.myapplication.di.databaseModel
import com.example.myapplication.di.repositoryModel
import com.example.myapplication.di.serviceAPIModule
import com.example.myapplication.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.workmanager.koin.workManagerFactory
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin

class App : Application(), KoinComponent {
    override fun onCreate() {
        super.onCreate()
        startKoin {
         //   androidLogger(Level.DEBUG)
            androidContext(this@App)
            workManagerFactory()
            modules(
                listOf(
                    viewModelModule,
                    repositoryModel,
                    serviceAPIModule,
                    databaseModel

                )
            )

        }
    }
}