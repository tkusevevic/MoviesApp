package com.fkulesevic.movielicious.firebase.authentication

import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseUser
import com.fkulesevic.movielicious.data.model.User
import com.fkulesevic.movielicious.firebase.EmptyRequestListener
import com.fkulesevic.movielicious.firebase.UserRequestListener

interface AuthenticationHelper {

    fun logTheUserIn(email: String, password: String, listener: UserRequestListener)

    fun attemptToRegisterTheUser(email: String, password: String, name: String, listener: EmptyRequestListener)

    fun setUserDisplayName(username: String)

    fun logTheUserOut()

    fun checkIfUserIsLoggedIn(): Boolean

    fun getCurrentUserId(): String?

    fun getCurrentUser(): FirebaseUser?

    fun editUser(user: User, listener: UserRequestListener)

    fun signInWithFacebook(credential : AuthCredential, listener: UserRequestListener)
}