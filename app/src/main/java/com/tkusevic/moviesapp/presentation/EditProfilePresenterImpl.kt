package com.tkusevic.moviesapp.presentation

import com.tkusevic.moviesapp.commons.extensions.mapToUser
import com.tkusevic.moviesapp.data.model.Movie
import com.tkusevic.moviesapp.data.model.User
import com.tkusevic.moviesapp.firebase.MoviesRequestListener
import com.tkusevic.moviesapp.firebase.UserRequestListener
import com.tkusevic.moviesapp.firebase.authentication.AuthenticationHelper
import com.tkusevic.moviesapp.firebase.database.DatabaseHelper
import com.tkusevic.moviesapp.ui.edit_profile.EditProfileView
import javax.inject.Inject

/**
 * Created by tkusevic on 25.02.2018..
 */
class EditProfilePresenterImpl @Inject constructor(private val authenticationHelper: AuthenticationHelper,
                                                   private val database: DatabaseHelper) : EditProfilePresenter,
        UserRequestListener, MoviesRequestListener {

    lateinit var editProfileView: EditProfileView

    override fun setBaseview(baseView: EditProfileView) {
        this.editProfileView = baseView
    }

    override fun setCurrentProfile() {
        val userId = authenticationHelper.getCurrentUserId()
        userId?.let { database.getUser(it, { this.onSuccessfulRequest(it) }) }
    }

    override fun onSuccessfulRequest(user: User) {
        editProfileView.setData(user)
    }

    override fun onFailedRequest() {
        //TODO NEKI FAIL
    }

    override fun saveChanges(aboutMe: String, movieDescription: String, name: String) {
        authenticationHelper.getCurrentUserId()?.let { database.getFavoriteMoviesOnce(it, { onSuccessfulRequest(it.toMutableList()) }) }
        val user = authenticationHelper.getCurrentUser()?.mapToUser()
        user?.let {
            it.userDisplayName = name
            it.description = aboutMe
            it.moviesDescription = movieDescription
            database.saveUser(user)
        }
    }

    override fun onSuccessfulRequest(movies: List<Movie>) {
        authenticationHelper.getCurrentUserId()?.let { database.addFavorites(it, movies) }
        editProfileView.editDone()
    }
}

