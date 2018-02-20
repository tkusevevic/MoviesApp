package com.tkusevic.moviesapp.ui.signIn

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.facebook.FacebookSdk
import com.facebook.appevents.AppEventsLogger
import com.tkusevic.moviesapp.R
import com.tkusevic.moviesapp.commons.constants.EMAIL_ERROR
import com.tkusevic.moviesapp.commons.constants.PASSWORD_ERROR
import com.tkusevic.moviesapp.commons.extensions.hide
import com.tkusevic.moviesapp.commons.extensions.onClick
import com.tkusevic.moviesapp.commons.extensions.show
import com.tkusevic.moviesapp.data.model.User
import com.tkusevic.moviesapp.presentation.SignInPresenter
import com.tkusevic.moviesapp.signInPresenter
import com.tkusevic.moviesapp.ui.movies.MoviesActivity
import com.tkusevic.moviesapp.ui.registration.RegistrationActivity
import kotlinx.android.synthetic.main.activity_sign_in.*


/**
 * Created by tkusevic on 14.02.2018..
 */
class SignInActivity : AppCompatActivity(), SignInView {

    private val presenter: SignInPresenter by lazy { signInPresenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        FacebookSdk.sdkInitialize(applicationContext)
        AppEventsLogger.activateApp(this)
        initPresenter()
        initListeners()
    }

    private fun initPresenter() {
        presenter.setBaseview(this)
    }

    private fun initListeners() {

        signIn.onClick { presenter.onSignInClick(emailSignIn.text.toString(), passwordSignIn.text.toString()) }

        signInFacebook.onClick { presenter.onFacebookClick() }

        //signInGoogle.onClick(presenter.onGoogleClick())

        goToRegistration.onClick { startActivity(Intent(this,RegistrationActivity::class.java)) }
    }

    override fun hidePasswordError() {
        layoutPasswordSign.isErrorEnabled = false
    }

    override fun hideEmailError() {
        layoutEmailSign.isErrorEnabled = false
    }

    override fun showPasswordError() {
        layoutPasswordSign.error = PASSWORD_ERROR
    }

    override fun showEmailError() {
        layoutEmailSign.error = EMAIL_ERROR
    }

    override fun showProgressAndHideOther() {
        progressSign.show()
        layoutWithoutImageSign.hide()
    }

    override fun hideProgressAndShowOther() {
        progressSign.hide()
        layoutWithoutImageSign.show()
    }

    override fun startMoviesActivity(user: User) {
        val intent = Intent(this, MoviesActivity::class.java)
        intent.putExtra("userId", user.id)
        startActivity(intent)
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
