package com.fkulesevic.movielicious

import com.fkulesevic.movielicious.presentation.*

fun topRatedPresenter(): TopRatedPresenter = App.appComponent.topRatedPresenter()

fun registrationPresenter(): RegistrationPresenter = App.appComponent.registrationPresenter()

fun signInPresenter(): SignInPresenter = App.appComponent.signInPresenter()

fun newFilmsPresenter(): NewFilmsPresenter = App.appComponent.newFilmsPresenter()

fun favoritesPresenter(): FavoritesPresenter = App.appComponent.favoritesPresenter()

fun movieDetailsPresenter(): MovieDetailsPresenter = App.appComponent.movieDetailsPresenter()

fun splashPresenter(): SplashPresenter = App.appComponent.splashPresenter()

fun movieSearchPresenter(): MovieSearchPresenter = App.appComponent.movieSearchPresenter()

