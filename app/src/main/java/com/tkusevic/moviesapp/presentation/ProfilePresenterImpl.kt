package com.tkusevic.moviesapp.presentation

import com.google.firebase.auth.FirebaseUser
import com.tkusevic.moviesapp.commons.extensions.mapToUser
import com.tkusevic.moviesapp.data.model.User
import com.tkusevic.moviesapp.firebase.UserRequestListener
import com.tkusevic.moviesapp.firebase.authentication.AuthenticationHelper
import com.tkusevic.moviesapp.firebase.database.DatabaseHelper
import com.tkusevic.moviesapp.ui.movies.views.ProfileView
import javax.inject.Inject

/**
 * Created by tkusevic on 19.02.2018..
 */
class ProfilePresenterImpl @Inject constructor(private val authenticationHelper: AuthenticationHelper,
                                               private val database: DatabaseHelper) : ProfilePresenter, UserRequestListener {

    private lateinit var profileView: ProfileView

    override fun setBaseview(baseView: ProfileView) {
        this.profileView = baseView
    }

    override fun editUser(aboutMe: String, movieDescription: String, name: String) {
        val firebaseUser: FirebaseUser? = authenticationHelper.getCurrentUser()
        val user = firebaseUser?.mapToUser()
        user?.run {
            description = aboutMe
            moviesDescription = movieDescription
            userDisplayName = name
        }
        user?.let { authenticationHelper.editUser(it, this) }
    }

    override fun getUserId() {
        val userId = authenticationHelper.getCurrentUserId().toString()
        database.getUser(userId, { this.onSuccessfulRequest(it) })
    }

    override fun onSuccessfulRequest(user: User) {
        profileView.setData(user)
        profileView.hideButton()
        profileView.textHideEdit()
    }

    override fun onFailedRequest() {
        profileView.makeText("failed profile edit!")
    }
}