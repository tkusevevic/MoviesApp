package com.tkusevic.moviesapp.di.module

import com.tkusevic.moviesapp.presentation.*
import dagger.Binds
import dagger.Module

/**
 * Created by tkusevic on 19.02.2018..
 */
@Module(includes = arrayOf(InteractorModule::class, AuthenticationModule::class))
abstract class PresentationModule {
    @Binds
    abstract fun profilePresenter(profilePresenterImpl: ProfilePresenterImpl): ProfilePresenter

    @Binds
    abstract fun registrationPresenter(registrationPresenterImpl: RegistrationPresenterImpl): RegistrationPresenter

    @Binds
    abstract fun signInPresenter(signInPresenterImpl: SignInPresenterImpl): SignInPresenter

    @Binds
    abstract fun topRatedPresenter(topRatedPresenterImpl: TopRatedPresenterImpl): TopRatedPresenter

    @Binds
    abstract fun newFilmsPresenter(newFilmsPresenterImpl: NewFilmsPresenterImpl) : NewFilmsPresenter

    @Binds
    abstract fun favoritesPresenter(favoritesPresenterImpl: FavoritesPresenterImpl) : FavoritesPresenter
}