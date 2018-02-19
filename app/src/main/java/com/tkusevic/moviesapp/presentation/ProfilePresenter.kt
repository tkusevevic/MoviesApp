package com.tkusevic.moviesapp.presentation

import com.tkusevic.moviesapp.base.BasePresenter
import com.tkusevic.moviesapp.ui.movies.views.ProfileView

/**
 * Created by tkusevic on 19.02.2018..
 */
interface ProfilePresenter : BasePresenter<ProfileView> {
    fun getUserId()

    fun editUser(aboutMe: String, movieDescription: String, name: String)

}