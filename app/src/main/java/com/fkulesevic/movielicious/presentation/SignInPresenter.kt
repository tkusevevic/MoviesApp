package com.fkulesevic.movielicious.presentation

import com.fkulesevic.movielicious.base.BasePresenter
import com.fkulesevic.movielicious.ui.signIn.SignInView

interface SignInPresenter : BasePresenter<SignInView> {

    fun onSignInClick(email: String, password: String)
}