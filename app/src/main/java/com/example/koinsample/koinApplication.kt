package com.example.koinsample

import android.app.Application
import com.example.koinsample.di.picassoModule
import com.example.koinsample.di.retrofitModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class koinApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@koinApplication)
            modules(listOf(retrofitModule, picassoModule))
        }
    }
}