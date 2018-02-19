package com.tkusevic.moviesapp.di.module

import com.tkusevic.moviesapp.firebase.authentication.AuthenticationHelper
import com.tkusevic.moviesapp.firebase.authentication.AuthenticationHelperImpl
import dagger.Binds
import dagger.Module

/**
 * Created by tkusevic on 19.02.2018..
 */

@Module(includes = arrayOf(DatabaseModule::class))
abstract class AuthenticationModule {

    @Binds
    abstract fun authenticationHelper(authenticationHelperImpl: AuthenticationHelperImpl): AuthenticationHelper
}