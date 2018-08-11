package com.tkusevic.moviesapp

import android.app.Application
import com.google.firebase.FirebaseApp
import com.tkusevic.moviesapp.di.AppComponent
import com.tkusevic.moviesapp.di.DaggerAppComponent
import com.tkusevic.moviesapp.di.module.AppModule

/**
 * Created by tkusevic on 14.02.2018..
 */
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