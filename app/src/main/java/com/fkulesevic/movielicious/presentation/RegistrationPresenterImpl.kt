package com.fkulesevic.movielicious.presentation

import com.fkulesevic.movielicious.commons.constants.FAILED_REGISRATION
import com.fkulesevic.movielicious.commons.constants.SUCCESS_REGISTRATION
import com.fkulesevic.movielicious.commons.utils.checkEmailEmpty
import com.fkulesevic.movielicious.commons.utils.checkNameEmpty
import com.fkulesevic.movielicious.commons.utils.checkPasswordEmpty
import com.fkulesevic.movielicious.commons.utils.isValidEmail
import com.fkulesevic.movielicious.firebase.EmptyRequestListener
import com.fkulesevic.movielicious.firebase.authentication.AuthenticationHelper
import com.fkulesevic.movielicious.ui.registration.RegistrationView
import javax.inject.Inject

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

