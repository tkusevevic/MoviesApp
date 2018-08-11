package com.tkusevic.moviesapp.ui.search_user.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.tkusevic.moviesapp.R
import com.tkusevic.moviesapp.data.model.User

class UserAdapter(private val onUserClick: (User) -> Unit) : RecyclerView.Adapter<UserViewHolder>() {

    private val users: MutableList<User> = mutableListOf()

    fun setUsers(users: List<User>) {
        this.users.clear()
        this.users.addAll(users)
        notifyDataSetChanged()
    }

    fun addMoreUsers(users: List<User>) {
        this.users.addAll(users)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_holder_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.setUser(users[position], onUserClick)
    }

    override fun getItemCount(): Int = users.size
}