package com.example.mycontacts

import android.app.Application
import com.example.mycontacts.di.AppComponent
import com.example.mycontacts.di.DaggerAppComponent

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .build()
    }

    companion object {
        lateinit var appComponent: AppComponent
    }
}