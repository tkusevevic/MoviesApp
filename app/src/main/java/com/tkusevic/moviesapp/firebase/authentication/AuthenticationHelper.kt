package com.tkusevic.moviesapp.firebase.authentication

import com.tkusevic.moviesapp.firebase.RequestListener
import com.tkusevic.moviesapp.firebase.UserListenerLogin

/**
 * Created by tkusevic on 14.02.2018..
 */
interface AuthenticationHelper {

    fun logTheUserIn(email: String, password: String, listener: UserListenerLogin)

    fun attemptToRegisterTheUser(email: String, password: String, name: String, listener: RequestListener)

    fun setUserDisplayName(username: String)

    fun logTheUserOut()

    fun checkIfUserIsLoggedIn(): Boolean

    val currentUserDisplayName: String
}