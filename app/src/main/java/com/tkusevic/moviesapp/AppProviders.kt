package com.tkusevic.moviesapp

import com.tkusevic.moviesapp.presentation.ProfilePresenter
import com.tkusevic.moviesapp.presentation.RegistrationPresenter
import com.tkusevic.moviesapp.presentation.SignInPresenter
import com.tkusevic.moviesapp.presentation.TopRatedPresenter

/**
 * Created by tkusevic on 14.02.2018..
 */


fun topRatedPresenter(): TopRatedPresenter = App.appComponent.topRatedPresenter()

fun registrationPresenter(): RegistrationPresenter = App.appComponent.registrationPresenter()

fun signInPresenter(): SignInPresenter = App.appComponent.signInPresenter()

fun profilePresenter(): ProfilePresenter = App.appComponent.profilePresenter()