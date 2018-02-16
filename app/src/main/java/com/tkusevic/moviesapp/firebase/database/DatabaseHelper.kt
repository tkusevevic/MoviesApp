package com.tkusevic.moviesapp.firebase.database

import com.tkusevic.moviesapp.data.model.User

/**
 * Created by tkusevic on 14.02.2018..
 */
interface DatabaseHelper {


    fun saveUser(user: User)

    fun getUser(id: String,onUserNesto : (User) -> Unit)

    fun editUser(user: User)

}