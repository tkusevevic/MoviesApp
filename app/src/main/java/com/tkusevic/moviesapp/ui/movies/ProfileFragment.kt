package com.tkusevic.moviesapp.ui.movies

import android.content.Intent
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
import com.tkusevic.moviesapp.presentation.ProfilePresenter
import com.tkusevic.moviesapp.profilePresenter
import com.tkusevic.moviesapp.ui.edit_profile.EditProfileActivity
import com.tkusevic.moviesapp.ui.movies.views.ProfileView
import kotlinx.android.synthetic.main.fragment_profile.*

/**
 * Created by tkusevic on 18.02.2018..
 */
class ProfileFragment : Fragment(), ProfileView {

    private val presenter: ProfilePresenter by lazy { profilePresenter() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
        initDataOnProfile()
    }

    private fun initDataOnProfile() {
        presenter.setBaseview(this)
        presenter.getUserId()
    }

    private fun initListeners() {
        editProfile.onClick { goToEdit() }
    }

    override fun setData(user: User) {
        profileEmail.text = user.email
        profileName.text = user.userDisplayName
        aboutMe.text = (user.description)
        profileMoviesDescription.text = user.moviesDescription
    }

    override fun makeText(s: String) = Toast.makeText(activity, s, Toast.LENGTH_SHORT).show()

    override fun goToEdit() {
        startActivity(Intent(activity,EditProfileActivity::class.java))
    }
}