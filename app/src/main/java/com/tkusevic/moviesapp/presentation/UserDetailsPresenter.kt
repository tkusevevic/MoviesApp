package com.tkusevic.moviesapp.presentation

import com.tkusevic.moviesapp.base.BasePresenter
import com.tkusevic.moviesapp.ui.user_details.UserDetailsView

interface UserDetailsPresenter : BasePresenter<UserDetailsView> {

    fun getUserFavoriteMovies(userId: String)
}