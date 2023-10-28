package com.example.myapplication

import android.app.Application
import com.example.myapplication.datalayer.di.dataSourceModule
import com.example.myapplication.datalayer.di.networkModule
import com.example.myapplication.datalayer.di.repositoryModule
import com.example.myapplication.datalayer.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        // init Koin
        startKoin {
            androidContext(this@MyApplication)
            modules(
                networkModule,
                dataSourceModule, 
                repositoryModule,
                viewModelModule
            )
        }

        // init Timber
        Timber.plant(Timber.DebugTree())
    }
}