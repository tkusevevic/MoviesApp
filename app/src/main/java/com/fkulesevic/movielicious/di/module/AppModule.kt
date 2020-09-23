package com.fkulesevic.movielicious.di.module

import android.content.Context
import android.content.SharedPreferences
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.fkulesevic.movielicious.commons.constants.PREFS_NAME
import com.fkulesevic.movielicious.preferences.PreferencesHelper
import com.fkulesevic.movielicious.preferences.PreferencesHelperImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
@Singleton
class AppModule constructor(private val context: Context) {

    @Provides
    fun provideContext(): Context = context

    @Provides
    fun firebaseDatabase(): FirebaseDatabase = FirebaseDatabase.getInstance()

    @Provides
    fun firebaseReference (firebaseDatabase: FirebaseDatabase): DatabaseReference = firebaseDatabase.reference

    @Provides
    fun firebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun sharedPreferences(context: Context): SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    @Provides
    fun preferenceHelper(sharedPreferences: SharedPreferences): PreferencesHelper = PreferencesHelperImpl(sharedPreferences)
}