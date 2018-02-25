package com.tkusevic.moviesapp.ui.edit_profile

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.tkusevic.moviesapp.R
import com.tkusevic.moviesapp.commons.extensions.onClick
import com.tkusevic.moviesapp.data.model.User
import com.tkusevic.moviesapp.editProfilePresenter
import com.tkusevic.moviesapp.presentation.EditProfilePresenter
import kotlinx.android.synthetic.main.activity_edit_profile.*

/**
 * Created by tkusevic on 23.02.2018..
 */
class EditProfileActivity : AppCompatActivity(), EditProfileView {

    private val presenter: EditProfilePresenter by lazy { editProfilePresenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)
        initPresenter()
        initListeners()
        setCurrentUserInfo()
    }

    private fun initListeners() {
        saveEditProfile.onClick { presenter.saveChanges(aboutMeEdit.text.toString()
                , profileEditMoviesDescription.text.toString()
                , profileEditName.text.toString()) }
    }

    private fun initPresenter() {
        presenter.setBaseview(this)
    }

    private fun setCurrentUserInfo() {
        presenter.setCurrentProfile()
    }

    override fun setData(user: User) {
        profileEditName.text= user.userDisplayName
        profileEditEmail.text= user.email
        aboutMeEdit.setText(user.description)
        profileEditMoviesDescription.setText(user.moviesDescription)
    }

    override fun editDone() {
        finish()
    }

}