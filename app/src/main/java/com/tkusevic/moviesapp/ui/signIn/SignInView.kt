package com.tkusevic.moviesapp.ui.signIn

import com.tkusevic.moviesapp.data.model.User

/**
 * Created by tkusevic on 15.02.2018..
 */
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