package com.tkusevic.moviesapp.presentation

import com.tkusevic.moviesapp.firebase.authentication.AuthenticationHelper
import com.tkusevic.moviesapp.firebase.database.DatabaseHelper
import com.tkusevic.moviesapp.ui.search_user.SearchUserView
import javax.inject.Inject

class SearchUserPresenterImpl @Inject constructor(private val authenticationHelper: AuthenticationHelper,
                                                  private val database: DatabaseHelper) : SearchUserPresenter {

    private lateinit var view: SearchUserView

    override fun setView(view: SearchUserView) {
        this.view = view
    }

    override fun getUsers(input: String) {
        database.getUsers { view.setUsers(it) }
    }

    override fun loadNextPage(page: Int) {

    }

    override fun getUser(userId: String) {
        database.getUser(userId) { view.openUserDetails(it) }
    }
}