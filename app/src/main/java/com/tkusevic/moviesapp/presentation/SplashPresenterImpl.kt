package com.tkusevic.moviesapp.presentation

import com.tkusevic.moviesapp.preferences.PreferencesHelper
import com.tkusevic.moviesapp.ui.splash.SplashView
import javax.inject.Inject

/**
 * Created by tkusevic on 27.02.2018..
 */
class SplashPresenterImpl @Inject constructor(private val preferencesHelper: PreferencesHelper): SplashPresenter {

    private lateinit var splashView: SplashView

    override fun setBaseview(baseView: SplashView) {
        splashView=baseView
    }

    override fun checkPrefs() {
        if (preferencesHelper.userIdExists()) {
            splashView.startApp()
        }
        else{
            splashView.startSignIn()
        }
    }
}