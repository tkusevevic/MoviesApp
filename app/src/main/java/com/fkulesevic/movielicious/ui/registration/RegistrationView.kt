package com.fkulesevic.movielicious.ui.registration

interface RegistrationView {

    fun showEmailError()

    fun showPasswordError()

    fun hideEmailError()

    fun hidePasswordError()

    fun showProgressAndHideOther()

    fun hideProgressAndShowOther()

    fun showNameError()

    fun hideNameError()

    fun showMessage(message: String)

    fun startSignIn()
}