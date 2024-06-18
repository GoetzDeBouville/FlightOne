package com.starbars.flightone

import android.app.Application
import android.util.Log
import com.starbars.search.di.searchFeatureModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(searchFeatureModule)
            Log.e("MyLog", "App onCreate")
        }
    }
}