package com.tkusevic.moviesapp.firebase

import com.tkusevic.moviesapp.data.model.User

/**
 * Created by tkusevic on 16.02.2018..
 */
interface UserListenerLogin {
    fun onSuccessfulRequest(user : User)

    fun onFailedRequest()
}