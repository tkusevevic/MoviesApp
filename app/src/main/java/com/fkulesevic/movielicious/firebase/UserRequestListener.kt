package com.fkulesevic.movielicious.firebase

import com.fkulesevic.movielicious.data.model.User

interface UserRequestListener {

    fun onSuccessfulRequest(user: User)

    fun onFailedRequest()
}