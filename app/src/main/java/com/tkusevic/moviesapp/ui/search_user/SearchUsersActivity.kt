package com.tkusevic.moviesapp.ui.search_user

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.tkusevic.moviesapp.R
import com.tkusevic.moviesapp.commons.constants.USER_KEY
import com.tkusevic.moviesapp.commons.extensions.onClick
import com.tkusevic.moviesapp.data.model.User
import com.tkusevic.moviesapp.searchUserPresenter
import com.tkusevic.moviesapp.ui.user_details.UserDetailsActivity
import com.tkusevic.moviesapp.ui.listeners.EndlessScrollListener
import com.tkusevic.moviesapp.ui.search_user.list.UserAdapter
import kotlinx.android.synthetic.main.activity_search_user.*

const val BLANK = ""

class SearchUsersActivity : AppCompatActivity(), SearchUserView {

    private val adapter by lazy { UserAdapter(this::onUserClick) }

    private val presenter by lazy { searchUserPresenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_user)
        presenter.setView(this)
        initUi()
        presenter.getUsers(BLANK)
    }

    private fun initUi() {
        setAdapter()
        setListeners()
    }

    private fun setAdapter() {
        recyclerViewSearchUser.adapter = adapter

        val lm = LinearLayoutManager(this)
        recyclerViewSearchUser.layoutManager = lm

        val scrollListener = object : EndlessScrollListener(lm) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {
                presenter.loadNextPage(page)
            }
        }
        recyclerViewSearchUser.addOnScrollListener(scrollListener)
    }

    override fun setUsers(users: List<User>) {
        adapter.setUsers(users)
    }

    private fun onUserClick(user: User) {
        presenter.getUser(user.id)
    }

    override fun addUsers(users: List<User>) {}

    private fun setListeners() {
        backSearch.onClick { finish() }
    }

    override fun clearList() {
        adapter.setUsers(emptyList())
    }

    override fun openUserDetails(user: User) {
        val bundle = Bundle()
        bundle.putSerializable(USER_KEY, user)
        val intent = Intent(this, UserDetailsActivity::class.java).putExtras(bundle)
        startActivity(intent)
    }
}