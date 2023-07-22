package com.example.shopdanisms.android

import android.app.Application
import di.androidModule
import di.appModule
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(appModule() + androidModule)
        }
    }
}