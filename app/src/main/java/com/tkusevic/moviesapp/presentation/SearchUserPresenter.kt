package com.tkusevic.moviesapp.presentation

import com.tkusevic.moviesapp.ui.search_user.SearchUserView

interface SearchUserPresenter {

    fun setView(view: SearchUserView)

    fun getUsers(input: String)

    fun getUser(userId: String)

    fun loadNextPage(page: Int)
}