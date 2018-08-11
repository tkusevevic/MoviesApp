package com.tkusevic.moviesapp.presentation

import com.tkusevic.moviesapp.firebase.database.DatabaseHelper
import com.tkusevic.moviesapp.ui.user_details.UserDetailsView
import javax.inject.Inject

class UserDetailsPresenterImpl @Inject constructor(private val database: DatabaseHelper) : UserDetailsPresenter {

    private lateinit var userDetailsView: UserDetailsView

    override fun setBaseview(baseView: UserDetailsView) {
        this.userDetailsView = baseView
    }

    override fun getUserFavoriteMovies(userId: String) {
        database.getFavoriteMoviesOnce(userId) { userDetailsView.setMovies(it) }
    }

}