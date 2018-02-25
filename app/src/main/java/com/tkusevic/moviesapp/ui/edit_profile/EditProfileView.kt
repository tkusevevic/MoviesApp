package com.tkusevic.moviesapp.ui.edit_profile

import com.tkusevic.moviesapp.data.model.User

/**
 * Created by tkusevic on 23.02.2018..
 */
interface EditProfileView {

    fun setData(user: User)

    fun editDone()
}