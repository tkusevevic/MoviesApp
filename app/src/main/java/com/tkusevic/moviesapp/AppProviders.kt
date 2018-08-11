package com.tkusevic.moviesapp

import com.tkusevic.moviesapp.presentation.*

/**
 * Created by tkusevic on 14.02.2018..
 */

fun topRatedPresenter(): TopRatedPresenter = App.appComponent.topRatedPresenter()

fun registrationPresenter(): RegistrationPresenter = App.appComponent.registrationPresenter()

fun signInPresenter(): SignInPresenter = App.appComponent.signInPresenter()

fun profilePresenter(): ProfilePresenter = App.appComponent.profilePresenter()

fun newFilmsPresenter(): NewFilmsPresenter = App.appComponent.newFilmsPresenter()

fun favoritesPresenter(): FavoritesPresenter = App.appComponent.favoritesPresenter()

fun movieDetailsPresenter(): MovieDetailsPresenter = App.appComponent.movieDetailsPresenter()

fun editProfilePresenter(): EditProfilePresenter = App.appComponent.editProfilePresenter()

fun splashPresenter(): SplashPresenter = App.appComponent.splashPresenter()

fun movieSearchPresenter(): MovieSearchPresenter = App.appComponent.movieSearchPresenter()

fun searchUserPresenter(): SearchUserPresenter = App.appComponent.searchUserPresenter()

fun userDetailsPresenter(): UserDetailsPresenter = App.appComponent.userDetailsPresenter()


