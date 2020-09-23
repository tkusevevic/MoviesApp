package com.fkulesevic.movielicious.di.module

import com.fkulesevic.movielicious.firebase.database.DatabaseHelper
import com.fkulesevic.movielicious.firebase.database.DatabaseHelperImpl
import dagger.Binds
import dagger.Module

@Module
abstract class DatabaseModule {

    @Binds
    abstract fun firebaseDatabase(databaseHelperImpl: DatabaseHelperImpl): DatabaseHelper
}