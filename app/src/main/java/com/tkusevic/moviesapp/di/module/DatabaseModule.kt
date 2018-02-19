package com.tkusevic.moviesapp.di.module

import com.tkusevic.moviesapp.firebase.database.DatabaseHelper
import com.tkusevic.moviesapp.firebase.database.DatabaseHelperImpl
import dagger.Binds
import dagger.Module

/**
 * Created by tkusevic on 19.02.2018..
 */

@Module
abstract class DatabaseModule {

    @Binds
    abstract fun firebaseDatabase(databaseHelperImpl: DatabaseHelperImpl): DatabaseHelper
}