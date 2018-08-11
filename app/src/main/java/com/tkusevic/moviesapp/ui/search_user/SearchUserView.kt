package com.tkusevic.moviesapp.ui.search_user

import com.tkusevic.moviesapp.data.model.User

interface SearchUserView {

    fun setUsers(users: List<User>)

    fun openUserDetails(user : User)

    fun addUsers(users: List<User>)

    fun clearList()
}