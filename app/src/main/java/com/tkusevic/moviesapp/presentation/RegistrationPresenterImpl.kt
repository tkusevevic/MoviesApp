package com.tkusevic.moviesapp.presentation

import com.tkusevic.moviesapp.ui.registration.RegistrationView

/**
 * Created by tkusevic on 15.02.2018..
 */
class RegistrationPresenterImpl : RegistrationPresenter {

    private lateinit var regView: RegistrationView

    override fun setBaseview(baseView: RegistrationView) {
        this.regView = baseView
    }

}

