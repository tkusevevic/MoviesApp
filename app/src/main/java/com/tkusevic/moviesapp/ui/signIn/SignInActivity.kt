package com.tkusevic.moviesapp.ui.signIn

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.facebook.FacebookSdk
import com.facebook.appevents.AppEventsLogger
import com.tkusevic.moviesapp.R
import com.tkusevic.moviesapp.commons.extensions.onClick
import com.tkusevic.moviesapp.data.model.User
import com.tkusevic.moviesapp.presentation.SignInPresenter
import com.tkusevic.moviesapp.presentation.SignInPresenterImpl
import kotlinx.android.synthetic.main.activity_sign_in.*

/**
 * Created by tkusevic on 14.02.2018..
 */
class SignInActivity : AppCompatActivity(), SignInView {

    override fun setUI(user: User?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private val presenter: SignInPresenter by lazy { SignInPresenterImpl() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        FacebookSdk.sdkInitialize(getApplicationContext())
        AppEventsLogger.activateApp(this)
        initPresenter()
        initListeners()
    }

    private fun initPresenter() {
        presenter.setBaseview(this)
    }

    private fun initListeners() {
        signIn.onClick { presenter.onSignInClick(emailSignIn.text.toString(),passwordSignIn.text.toString()) }

        signInFacebook.onClick { presenter.onFacebookClick() }

        //signInGoogle.onClick(presenter.onGoogleClick())
    }

    override fun hidePasswordError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideEmailError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showPasswordError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showEmailError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showProgressAndHideOther() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideProgressAndShowOther() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
