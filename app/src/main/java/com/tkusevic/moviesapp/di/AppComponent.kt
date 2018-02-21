package com.tkusevic.moviesapp.di

import android.app.Presentation
import com.tkusevic.moviesapp.App
import com.tkusevic.moviesapp.di.module.AppModule
import com.tkusevic.moviesapp.di.module.InteractorModule
import com.tkusevic.moviesapp.di.module.PresentationModule
import com.tkusevic.moviesapp.presentation.*
import dagger.Component
import javax.inject.Singleton

/**
 * Created by tkusevic on 14.02.2018..
 */
@Singleton
@Component(modules = arrayOf(PresentationModule::class, AppModule::class))
interface AppComponent {

    fun inject(app: App)

    fun profilePresenter(): ProfilePresenter

    fun registrationPresenter(): RegistrationPresenter

    fun signInPresenter(): SignInPresenter

    fun topRatedPresenter(): TopRatedPresenter

    fun newFilmsPresenter() : NewFilmsPresenter

    fun favoritesPresenter() : FavoritesPresenter

}