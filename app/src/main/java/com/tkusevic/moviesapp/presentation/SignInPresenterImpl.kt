package com.tkusevic.moviesapp.presentation

import com.tkusevic.moviesapp.commons.utils.checkEmailEmpty
import com.tkusevic.moviesapp.commons.utils.checkPasswordEmpty
import com.tkusevic.moviesapp.data.model.User
import com.tkusevic.moviesapp.firebase.authentication.AuthenticationHelper
import com.tkusevic.moviesapp.firebase.authentication.AuthenticationHelperImpl
import com.tkusevic.moviesapp.firebase.userListenerLogin
import com.tkusevic.moviesapp.ui.signIn.SignInView


/**
 * Created by tkusevic on 15.02.2018..
 */
class SignInPresenterImpl : SignInPresenter, userListenerLogin {

    private val authenticationHelper: AuthenticationHelper by lazy { AuthenticationHelperImpl() }

    private lateinit var signView: SignInView

    override fun setBaseview(baseView: SignInView) {
        this.signView = baseView
    }

    override fun onSignInClick(email: String, password: String) {
        signView.showProgressAndHideOther()
        if (!email.isEmpty() && !password.isEmpty() && password.length > 5) {
            tryToSignIn(email, password)
        } else {
            signView.hideProgressAndShowOther()
        }
        checkInputEmpty(email, password)
    }

    private fun tryToSignIn(email: String, password: String) {
        authenticationHelper.logTheUserIn(email, password, this)
    }

    private fun checkInputEmpty(email: String, password: String) {
        if (checkEmailEmpty(email.trim()))
            signView.showEmailError()
        else signView.hideEmailError()

        if (checkPasswordEmpty(password.trim()) || password.trim().length < 6)
            signView.showPasswordError()
        else signView.hidePasswordError()
    }

    override fun onFacebookClick() {

    }

    override fun onSuccessfulRequest(user: User) {
        signView.hideProgressAndShowOther()
        signView.showMessage(user.toString())
    }

    override fun onFailedRequest() {
        signView.hideProgressAndShowOther()
        signView.showMessage("WRONG EMAIL OR PASSWORD")
    }

}