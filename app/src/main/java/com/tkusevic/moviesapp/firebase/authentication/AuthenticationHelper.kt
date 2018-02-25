package com.tkusevic.moviesapp.firebase.authentication

import com.google.firebase.auth.FirebaseUser
import com.tkusevic.moviesapp.data.model.User
import com.tkusevic.moviesapp.firebase.EmptyRequestListener
import com.tkusevic.moviesapp.firebase.UserRequestListener

/**
 * Created by tkusevic on 14.02.2018..
 */
interface AuthenticationHelper {

    fun logTheUserIn(email: String, password: String, listener: UserRequestListener)

    fun attemptToRegisterTheUser(email: String, password: String, name: String, listener: EmptyRequestListener)

    fun setUserDisplayName(username: String)

    fun logTheUserOut()

    fun checkIfUserIsLoggedIn(): Boolean

    fun getCurrentUserId(): String?

    fun getCurrentUser(): FirebaseUser?

    fun editUser(user: User, listener: UserRequestListener)

    val currentUserDisplayName: String
}