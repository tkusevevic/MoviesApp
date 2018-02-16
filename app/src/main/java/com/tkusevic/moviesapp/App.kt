package com.tkusevic.moviesapp

import android.app.Application
import com.google.firebase.FirebaseApp

/**
 * Created by tkusevic on 14.02.2018..
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
    }
}