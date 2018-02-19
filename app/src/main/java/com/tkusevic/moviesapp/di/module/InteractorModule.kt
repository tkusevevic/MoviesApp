package com.tkusevic.moviesapp.di.module

import com.tkusevic.moviesapp.interaction.MoviesInteractor
import com.tkusevic.moviesapp.interaction.MoviesInteractorImpl
import dagger.Binds
import dagger.Module

/**
 * Created by tkusevic on 19.02.2018..
 */
@Module(includes = arrayOf(NetworkingModule::class))
abstract class InteractorModule {

    @Binds
    abstract fun moviesInteractor(moviesInteractorImpl: MoviesInteractorImpl): MoviesInteractor
}