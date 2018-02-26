package com.tkusevic.moviesapp.presentation

import com.tkusevic.moviesapp.commons.constants.FAILED_REGISRATION
import com.tkusevic.moviesapp.commons.constants.SUCCESS_REGISTRATION
import com.tkusevic.moviesapp.commons.utils.checkEmailEmpty
import com.tkusevic.moviesapp.commons.utils.checkNameEmpty
import com.tkusevic.moviesapp.commons.utils.checkPasswordEmpty
import com.tkusevic.moviesapp.commons.utils.isValidEmail
import com.tkusevic.moviesapp.firebase.EmptyRequestListener
import com.tkusevic.moviesapp.firebase.authentication.AuthenticationHelper
import com.tkusevic.moviesapp.ui.registration.RegistrationView
import javax.inject.Inject

/**
 * Created by tkusevic on 15.02.2018..
 */
class RegistrationPresenterImpl @Inject constructor(private val authenticationHelper: AuthenticationHelper) : RegistrationPresenter, EmptyRequestListener {

    private lateinit var regView: RegistrationView

    override fun setBaseview(baseView: RegistrationView) {
        this.regView = baseView
    }

    override fun onRegistrationClick(email: String, password: String, name: String) {
        regView.showProgressAndHideOther()
        if (!email.isEmpty() && !password.isEmpty() && password.length > 5)
            tryToRegister(email, password, name)
        else
            regView.hideProgressAndShowOther()
        chechInputEmpty(email, password, name)
    }

    private fun chechInputEmpty(email: String, password: String, name: String) {
        if (checkEmailEmpty(email.trim()) || !isValidEmail(email.trim())) regView.showEmailError() else regView.hideEmailError()

        if (checkPasswordEmpty(password.trim()) || password.trim().length < 6) regView.showPasswordError() else regView.hidePasswordError()

        if (checkNameEmpty(name.trim())) regView.showNameError() else regView.hideNameError()
    }

    private fun tryToRegister(email: String, password: String, name: String) {
        authenticationHelper.attemptToRegisterTheUser(email, password, name, this)
    }

    override fun onSuccessfulRequest() {
        regView.hideProgressAndShowOther()
        regView.showMessage(SUCCESS_REGISTRATION)
        regView.startSignIn()
    }

    override fun onFailedRequest() {
        regView.hideProgressAndShowOther()
        regView.showMessage(FAILED_REGISRATION)
    }
}

