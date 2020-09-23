package com.fkulesevic.movielicious.di.module

import com.fkulesevic.movielicious.firebase.authentication.AuthenticationHelper
import com.fkulesevic.movielicious.firebase.authentication.AuthenticationHelperImpl
import dagger.Binds
import dagger.Module

@Module(includes = arrayOf(DatabaseModule::class))
abstract class AuthenticationModule {

    @Binds
    abstract fun authenticationHelper(authenticationHelperImpl: AuthenticationHelperImpl): AuthenticationHelper
}