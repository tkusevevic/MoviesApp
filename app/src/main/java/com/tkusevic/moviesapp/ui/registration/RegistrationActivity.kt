package com.tkusevic.moviesapp.ui.registration

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.tkusevic.moviesapp.R
import com.tkusevic.moviesapp.commons.constants.EMAIL_ERROR
import com.tkusevic.moviesapp.commons.constants.NO_NAME_ERROR
import com.tkusevic.moviesapp.commons.constants.PASSWORD_ERROR
import com.tkusevic.moviesapp.commons.extensions.hide
import com.tkusevic.moviesapp.commons.extensions.onClick
import com.tkusevic.moviesapp.commons.extensions.show
import com.tkusevic.moviesapp.firebase.RequestListener
import com.tkusevic.moviesapp.presentation.RegistrationPresenter
import com.tkusevic.moviesapp.presentation.RegistrationPresenterImpl
import com.tkusevic.moviesapp.ui.signIn.SignInActivity
import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationActivity : AppCompatActivity(), RegistrationView, RequestListener {

    private val presenter: RegistrationPresenter by lazy { RegistrationPresenterImpl() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        initPresenter()
        initListeners()
    }

    private fun initPresenter() {
        presenter.setBaseview(this)
    }

    private fun initListeners() {
        registrationBtn.onClick {
            presenter.onRegistrationClick(
                    email.text.toString()
                    , password.text.toString()
                    , name.text.toString())
        }

        goToLogin.onClick { startActivity(Intent(this, SignInActivity::class.java)) }
    }

    //////// View

    override fun onSuccessfulRequest() {
        startActivity(Intent(this, SignInActivity::class.java))
        hideProgressAndShowOther()
    }

    override fun onFailedRequest() {
        hideProgressAndShowOther()
    }

    override fun showProgressAndHideOther() {
        progress.show()
        layoutWithoutImage.hide()
    }

    override fun hideProgressAndShowOther() {
        progress.hide()
        layoutWithoutImage.show()
    }

    override fun showEmailError() {
        layoutEmail.error = EMAIL_ERROR
    }

    override fun showPasswordError() {
        layoutPassword.error = PASSWORD_ERROR
    }

    override fun hideEmailError() {
        layoutEmail.isErrorEnabled = false
    }

    override fun hidePasswordError() {
        layoutPassword.isErrorEnabled = false
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showNameError() {
        layoutName.error = NO_NAME_ERROR
    }

    override fun hideNameError() {
        layoutName.isErrorEnabled = false
    }

}
