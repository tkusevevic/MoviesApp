package com.tkusevic.moviesapp.presentation

import com.tkusevic.moviesapp.base.BasePresenter
import com.tkusevic.moviesapp.ui.edit_profile.EditProfileView

/**
 * Created by tkusevic on 25.02.2018..
 */
interface EditProfilePresenter : BasePresenter<EditProfileView> {

    fun setCurrentProfile()

    fun saveChanges(aboutMe: String, movieDescription: String, name: String)
}