package com.fkulesevic.movielicious.di

import com.fkulesevic.movielicious.App
import com.fkulesevic.movielicious.di.module.AppModule
import com.fkulesevic.movielicious.di.module.PresentationModule
import com.fkulesevic.movielicious.presentation.*
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(PresentationModule::class, AppModule::class))
interface AppComponent {

    fun inject(app: App)

    fun registrationPresenter(): RegistrationPresenter

    fun signInPresenter(): SignInPresenter

    fun topRatedPresenter(): TopRatedPresenter

    fun newFilmsPresenter(): NewFilmsPresenter

    fun favoritesPresenter(): FavoritesPresenter

    fun movieDetailsPresenter(): MovieDetailsPresenter

    fun splashPresenter(): SplashPresenter

    fun movieSearchPresenter(): MovieSearchPresenter
}