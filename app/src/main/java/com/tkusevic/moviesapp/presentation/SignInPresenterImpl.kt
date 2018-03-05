package com.tkusevic.moviesapp.presentation

import com.facebook.AccessToken
import com.google.firebase.auth.FacebookAuthProvider
import com.tkusevic.moviesapp.commons.constants.ERROR_EMAIL_OR_PASSWORD
import com.tkusevic.moviesapp.commons.utils.checkEmailEmpty
import com.tkusevic.moviesapp.commons.utils.checkPasswordEmpty
import com.tkusevic.moviesapp.commons.utils.isValidEmail
import com.tkusevic.moviesapp.data.model.User
import com.tkusevic.moviesapp.firebase.UserRequestListener
import com.tkusevic.moviesapp.firebase.authentication.AuthenticationHelper
import com.tkusevic.moviesapp.preferences.PreferencesHelper
import com.tkusevic.moviesapp.ui.signIn.SignInView
import javax.inject.Inject


/**
 * Created by tkusevic on 15.02.2018..
 */
class SignInPresenterImpl @Inject constructor(private val authenticationHelper: AuthenticationHelper,
                                              private val preferencesHelper: PreferencesHelper) : SignInPresenter, UserRequestListener {

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
        if (checkEmailEmpty(email.trim()) || !isValidEmail(email.trim()))
            signView.showEmailError()
        else signView.hideEmailError()

        if (checkPasswordEmpty(password.trim()) || password.trim().length < 6)
            signView.showPasswordError()
        else signView.hidePasswordError()
    }

   override fun handleFacebookAccessToken(token: AccessToken) {
       signView.showProgressAndHideOther()
       val credential = FacebookAuthProvider.getCredential(token.token)
       authenticationHelper.signInWithFacebook(credential,this)
   }

    override fun onSuccessfulRequest(user: User) {
        preferencesHelper.saveId(user.id)
        signView.startMoviesActivity(user)
        signView.hideProgressAndShowOther()
    }

    override fun onFailedRequest() {
        signView.hideProgressAndShowOther()
        signView.showMessage(ERROR_EMAIL_OR_PASSWORD)
    }
}