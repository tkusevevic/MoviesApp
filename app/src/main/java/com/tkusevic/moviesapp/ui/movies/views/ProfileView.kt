package com.tkusevic.moviesapp.ui.movies.views

import com.tkusevic.moviesapp.data.model.User

/**
 * Created by tkusevic on 19.02.2018..
 */
interface ProfileView {

    fun setData(user: User)
    fun makeText(s: String)
    fun hideButton()
    fun textGiveEdit()
    fun textHideEdit()
}