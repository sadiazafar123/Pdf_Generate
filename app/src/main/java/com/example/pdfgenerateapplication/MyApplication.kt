package com.example.pdfgenerateapplication

import android.app.Application
import com.example.pdfgenerateapplication.module.networkModule
import com.example.pdfgenerateapplication.module.repositoryModule
import com.example.pdfgenerateapplication.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(listOf(networkModule,repositoryModule,  viewModelModule))
        }
    }

}