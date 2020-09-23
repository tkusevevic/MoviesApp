package com.fkulesevic.movielicious

import android.app.Application
import com.google.firebase.FirebaseApp
import com.fkulesevic.movielicious.di.AppComponent
import com.fkulesevic.movielicious.di.DaggerAppComponent
import com.fkulesevic.movielicious.di.module.AppModule

class App : Application() {

    companion object {
        val appComponent: AppComponent by lazy { DaggerAppComponent.builder().appModule(AppModule(instance)).build() }

        internal lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
        instance = this
        appComponent.inject(this)
    }
}