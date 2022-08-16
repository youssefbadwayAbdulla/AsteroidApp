package com.example.myapplication

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.work.*
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.presentation.services.AppWorkManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val applicationScope = CoroutineScope(Dispatchers.Default)
    private val workManager: WorkManager by lazy {
        WorkManager.getInstance(this)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        applicationScope.launch {
            getWork()
        }


    }

    private fun getWork(){
         val workAppResult: WorkRequest =
            OneTimeWorkRequestBuilder<AppWorkManager>()
                .setConstraints(
                    Constraints.Builder()
                        .setRequiredNetworkType(NetworkType.CONNECTED)
                        .setRequiresCharging(true)
                        .build()
                ).build()
        workManager.enqueue(workAppResult)
    }

}