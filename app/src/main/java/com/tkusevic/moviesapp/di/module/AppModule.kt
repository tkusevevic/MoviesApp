package com.tkusevic.moviesapp.di.module

import android.content.Context
import android.content.SharedPreferences
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.tkusevic.moviesapp.commons.constants.PREFS_NAME
import com.tkusevic.moviesapp.preferences.PreferencesHelper
import com.tkusevic.moviesapp.preferences.PreferencesHelperImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by tkusevic on 19.02.2018..
 */
@Module
@Singleton
class AppModule constructor(private val context: Context) {

    @Provides
    fun provideContext(): Context = context

    @Provides
    fun firebaseDatabase(): FirebaseDatabase = FirebaseDatabase.getInstance()

    @Provides
    fun firebaseReference(firebaseDatabase: FirebaseDatabase): DatabaseReference = firebaseDatabase.reference


    @Provides
    fun firebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun sharedPreferences(context: Context): SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    @Provides
    fun preferenceHelper(sharedPreferences: SharedPreferences): PreferencesHelper = PreferencesHelperImpl(sharedPreferences)
}