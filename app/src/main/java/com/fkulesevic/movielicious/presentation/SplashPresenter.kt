package com.fkulesevic.movielicious.presentation

import com.fkulesevic.movielicious.base.BasePresenter
import com.fkulesevic.movielicious.ui.splash.SplashView

interface SplashPresenter: BasePresenter<SplashView> {

    fun checkPrefs()
}