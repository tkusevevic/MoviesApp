package com.tkusevic.moviesapp.ui.registration

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.tkusevic.moviesapp.R
import com.tkusevic.moviesapp.commons.constants.EMAIL_ERROR
import com.tkusevic.moviesapp.commons.constants.PASSWORD_ERROR
import com.tkusevic.moviesapp.commons.extensions.hide
import com.tkusevic.moviesapp.commons.extensions.onClick
import com.tkusevic.moviesapp.commons.extensions.show
import com.tkusevic.moviesapp.commons.utils.*
import com.tkusevic.moviesapp.firebase.RequestListener
import com.tkusevic.moviesapp.firebase.authentication.AuthenticationHelper
import com.tkusevic.moviesapp.firebase.authentication.AuthenticationHelperImpl
import com.tkusevic.moviesapp.presentation.RegistrationPresenter
import com.tkusevic.moviesapp.presentation.RegistrationPresenterImpl
import com.tkusevic.moviesapp.ui.signIn.SignInActivity
import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationActivity : AppCompatActivity(), RegistrationView, RequestListener {

    //TODO LOGIKA U PRESENTER

    private val presenter: RegistrationPresenter by lazy { RegistrationPresenterImpl() }

    private val authenticationHelper: AuthenticationHelper by lazy { AuthenticationHelperImpl() }

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
            showProgressHideLayout()
            if (checkInputs(email.text.toString(), password.text.toString(), name.text.toString())) {
                tryToSaveToDatabase()
                hideErrors()
            } else checkValidation()
        }

        goToLogin.onClick { startActivity(Intent(this, SignInActivity::class.java)) }
    }

    private fun checkValidation() {
        Toast.makeText(this, "Input all fields!", Toast.LENGTH_SHORT).show()
        if (checkEmailEmpty(email.text.toString()))
            layoutEmail.error = "Empty email!"
        else
            layoutEmail.isErrorEnabled = false

        if (checkPasswordEmpty(password.text.toString()))
            layoutPassword.error = "Empty password"
        else
            layoutPassword.isErrorEnabled = false

        if (checkNameEmpty(name.text.toString()))
            layoutName.error = "Empty name"
        else
            layoutName.isErrorEnabled = false

        progress.hide()
        layoutWithoutImage.show()
    }

    private fun showProgressHideLayout() {
        progress.show()
        layoutWithoutImage.hide()
    }

    private fun tryToSaveToDatabase() {
        authenticationHelper.attemptToRegisterTheUser(email.text.toString()
                , password.text.toString()
                , name.text.toString()
                , this)
    }

    private fun hideErrors() {
        layoutEmail.isErrorEnabled = false
        layoutPassword.isErrorEnabled = false
    }

    //success on register try
    override fun onSuccessfulRequest() {
        //waitingForProcess()
        startActivity(Intent(this, SignInActivity::class.java))
    }

    //fail on register try
    override fun onFailedRequest() {
        //processDone()
    }

    //override fun waitingForProcess() {
    //    progress.show()
    //    layoutWithoutImage.hide()
    //}

    //override fun processDone() {
    //    errorHandling()
    //    progress.hide()
    //    layoutWithoutImage.show()
    //}

    private fun errorHandling() {
        if (isPasswordCorrect(password.text.toString().trim()))
            layoutPassword.error = PASSWORD_ERROR
        else {
            layoutEmail.error = EMAIL_ERROR
        }
    }

    override fun showProgressAndHideOther() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideProgressAndShowOther() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showEmailError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showPasswordError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideEmailError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hidePasswordError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

