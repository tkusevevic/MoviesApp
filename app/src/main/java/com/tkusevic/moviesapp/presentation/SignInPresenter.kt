package com.tkusevic.moviesapp.presentation

import com.facebook.AccessToken
import com.tkusevic.moviesapp.base.BasePresenter
import com.tkusevic.moviesapp.ui.signIn.SignInView

/**
 * Created by tkusevic on 15.02.2018..
 */
interface SignInPresenter : BasePresenter<SignInView> {

    fun onSignInClick(email: String, password: String)

    fun onGoogleClick()
}