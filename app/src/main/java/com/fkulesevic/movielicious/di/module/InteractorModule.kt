package com.fkulesevic.movielicious.di.module

import com.fkulesevic.movielicious.interaction.MoviesInteractor
import com.fkulesevic.movielicious.interaction.MoviesInteractorImpl
import dagger.Binds
import dagger.Module

@Module(includes = arrayOf(NetworkingModule::class))
abstract class InteractorModule {

    @Binds
    abstract fun moviesInteractor(moviesInteractorImpl: MoviesInteractorImpl): MoviesInteractor
}