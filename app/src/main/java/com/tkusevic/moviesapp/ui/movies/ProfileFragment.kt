package com.tkusevic.moviesapp.ui.movies

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.tkusevic.moviesapp.R
import com.tkusevic.moviesapp.commons.extensions.hide
import com.tkusevic.moviesapp.commons.extensions.onClick
import com.tkusevic.moviesapp.commons.extensions.show
import com.tkusevic.moviesapp.data.model.User
import com.tkusevic.moviesapp.firebase.authentication.AuthenticationHelper
import com.tkusevic.moviesapp.firebase.authentication.AuthenticationHelperImpl
import com.tkusevic.moviesapp.presentation.ProfilePresenter
import com.tkusevic.moviesapp.presentation.ProfilePresenterImpl
import kotlinx.android.synthetic.main.fragment_profile.*

/**
 * Created by tkusevic on 18.02.2018..
 */
class ProfileFragment : Fragment(), ProfileView {

    private val profilePresenter: ProfilePresenter by lazy { ProfilePresenterImpl() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initPresenter()
        initAdapter()
        textHideEdit()
        initListeners()
    }

    private fun initListeners() {
        editProfile.onClick {
            if (saveProfile.visibility == View.GONE) {
                saveProfile.show()
                textGiveEdit()
            }
            else {
                saveProfile.hide()
                textHideEdit()
            }
        }

        saveProfile.onClick {
            profilePresenter.editUser(aboutMe.text.toString(), profileMoviesDescription.text.toString(), profileName.text.toString())
        }
    }

    private fun initPresenter() {
        profilePresenter.setBaseview(this)
        profilePresenter.getUserId()
    }

    private fun initAdapter() {
    }


    override fun setData(user: User) {
        profileEmail.text = user.email
        profileName.text = user.userDisplayName
        aboutMe.setText(user.description)
        profileMoviesDescription.setText(user.moviesDescription)
    }

    override fun makeText(s: String) {
        Toast.makeText(activity, s, Toast.LENGTH_SHORT).show()
    }

    override fun hideButton() {
        saveProfile.hide()
    }

    override fun textGiveEdit() {
        aboutMe.isEnabled = true
        profileMoviesDescription.isEnabled = true
    }

    override fun textHideEdit() {
        aboutMe.isEnabled = false
        profileMoviesDescription.isEnabled = false
    }
}