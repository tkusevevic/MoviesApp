package com.tkusevic.moviesapp.presentation

import com.tkusevic.moviesapp.base.BasePresenter
import com.tkusevic.moviesapp.ui.splash.SplashView

/**
 * Created by tkusevic on 27.02.2018..
 */
interface SplashPresenter: BasePresenter<SplashView> {

    fun checkPrefs()
}