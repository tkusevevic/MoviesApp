package com.fkulesevic.movielicious.presentation

import com.fkulesevic.movielicious.base.BasePresenter
import com.fkulesevic.movielicious.ui.registration.RegistrationView

interface RegistrationPresenter : BasePresenter<RegistrationView> {

    fun onRegistrationClick(email: String, password: String, name: String)
}