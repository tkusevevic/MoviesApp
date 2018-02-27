package com.tkusevic.moviesapp.ui.splash

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.tkusevic.moviesapp.presentation.SplashPresenter
import com.tkusevic.moviesapp.splashPresenter
import com.tkusevic.moviesapp.ui.movies.MoviesActivity
import com.tkusevic.moviesapp.ui.signIn.SignInActivity

/**
 * Created by tkusevic on 27.02.2018..
 */
class SplashActivity : AppCompatActivity(), SplashView {

    private val presenter: SplashPresenter by lazy { splashPresenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.setBaseview(this)
        presenter.checkPrefs()
    }

    override fun startApp() {
        startActivity(Intent(this, MoviesActivity::class.java))
        finish()
    }

    override fun startSignIn() {
        startActivity(Intent(this, SignInActivity::class.java))
        finish()
    }
}