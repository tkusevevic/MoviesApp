package com.tkusevic.moviesapp.ui.signIn

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.FacebookSdk
import com.facebook.appevents.AppEventsLogger
import com.facebook.login.LoginResult
import com.tkusevic.moviesapp.R
import com.tkusevic.moviesapp.commons.constants.*
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

    private val callbackManager = CallbackManager.Factory.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        FacebookSdk.getSdkVersion()
        AppEventsLogger.activateApp(application)
        initPresenter()
        initFacebook()
        initListeners()
    }

    private fun initFacebook() {
        signInFacebook.setReadPermissions(FACEBOOK_EMAIL, FACEBOOK_PROFILE)
        signInFacebook.registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
            override fun onSuccess(result: LoginResult) {
                presenter.handleFacebookAccessToken(result.accessToken)
            }

            override fun onCancel() {
            }

            override fun onError(error: FacebookException?) {
                showMessage(FACEBOOK_ERROR)
            }
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        callbackManager.onActivityResult(requestCode, resultCode, data)
    }

    private fun initPresenter() = presenter.setBaseview(this)

    private fun initListeners() {
        signIn.onClick { presenter.onSignInClick(emailSignIn.text.toString(), passwordSignIn.text.toString()) }

        goToRegistration.onClick { startActivity(Intent(this, RegistrationActivity::class.java)) }
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
        startActivity(intent)
        finish()
    }

    override fun showMessage(message: String) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}
