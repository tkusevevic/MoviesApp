package com.fkulesevic.movielicious.ui.signIn

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.fkulesevic.movielicious.R
import com.fkulesevic.movielicious.commons.constants.*
import com.fkulesevic.movielicious.commons.extensions.hide
import com.fkulesevic.movielicious.commons.extensions.onClick
import com.fkulesevic.movielicious.commons.extensions.show
import com.fkulesevic.movielicious.data.model.User
import com.fkulesevic.movielicious.presentation.SignInPresenter
import com.fkulesevic.movielicious.signInPresenter
import com.fkulesevic.movielicious.ui.movies.MoviesActivity
import com.fkulesevic.movielicious.ui.registration.RegistrationActivity
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity(), SignInView {

    private val presenter: SignInPresenter by lazy { signInPresenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        initPresenter()
        initListeners()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
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
