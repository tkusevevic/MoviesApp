package com.fkulesevic.movielicious.presentation

import com.fkulesevic.movielicious.preferences.PreferencesHelper
import com.fkulesevic.movielicious.ui.splash.SplashView
import javax.inject.Inject

class SplashPresenterImpl @Inject constructor(private val preferencesHelper: PreferencesHelper): SplashPresenter {

    private lateinit var splashView: SplashView

    override fun setBaseview(baseView: SplashView) {
        splashView=baseView
    }

    override fun checkPrefs() = if(preferencesHelper.userIdExists()) splashView.startApp() else splashView.startSignIn()
}