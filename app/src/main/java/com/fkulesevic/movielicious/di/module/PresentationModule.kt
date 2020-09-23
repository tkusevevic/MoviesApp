package com.fkulesevic.movielicious.di.module

import com.fkulesevic.movielicious.presentation.*
import dagger.Binds
import dagger.Module

@Module(includes = arrayOf(InteractorModule::class, AuthenticationModule::class))
abstract class PresentationModule {

    @Binds
    abstract fun registrationPresenter(registrationPresenterImpl: RegistrationPresenterImpl): RegistrationPresenter

    @Binds
    abstract fun signInPresenter(signInPresenterImpl: SignInPresenterImpl): SignInPresenter

    @Binds
    abstract fun topRatedPresenter(topRatedPresenterImpl: TopRatedPresenterImpl): TopRatedPresenter

    @Binds
    abstract fun newFilmsPresenter(newFilmsPresenterImpl: NewFilmsPresenterImpl): NewFilmsPresenter

    @Binds
    abstract fun favoritesPresenter(favoritesPresenterImpl: FavoritesPresenterImpl): FavoritesPresenter

    @Binds
    abstract fun movieDetailsPresenter(movieDetailsPresenterImpl: MovieDetailsPresenterImpl): MovieDetailsPresenter

    @Binds
    abstract fun splashPresenter(splashPresenterImpl: SplashPresenterImpl): SplashPresenter

    @Binds
    abstract fun movieSearchPresenter(movieSearchPresenterImpl: MovieSearchPresenterImpl): MovieSearchPresenter
}