package com.tkusevic.moviesapp.ui.registration

/**
 * Created by tkusevic on 15.02.2018..
 */
interface RegistrationView {

    fun showEmailError()

    fun showPasswordError()

    fun hideEmailError()

    fun hidePasswordError()

    fun showProgressAndHideOther()

    fun hideProgressAndShowOther()
}