package com.tkusevic.moviesapp.ui.search_user.list

import android.support.v7.widget.RecyclerView
import android.view.View
import com.tkusevic.moviesapp.commons.extensions.onClick
import com.tkusevic.moviesapp.data.model.User
import kotlinx.android.synthetic.main.list_holder_user.view.*

class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun setUser(user: User, onClickUser: (User) -> Unit) = with(itemView) {
        nameUserHolder.text = user.userDisplayName
        moviesDescriptionUserHolder.text = user.moviesDescription
        onClick { onClickUser(user) }
    }
}