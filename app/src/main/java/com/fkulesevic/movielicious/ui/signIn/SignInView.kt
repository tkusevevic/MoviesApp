package com.fkulesevic.movielicious.ui.signIn

import com.fkulesevic.movielicious.data.model.User

interface SignInView {

    fun showEmailError()

    fun showPasswordError()

    fun hideEmailError()

    fun hidePasswordError()

    fun showProgressAndHideOther()

    fun hideProgressAndShowOther()

    fun startMoviesActivity(user: User)

    fun showMessage(message: String)
}