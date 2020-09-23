package com.fkulesevic.movielicious.firebase.authentication

import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import com.fkulesevic.movielicious.commons.extensions.mapToUser
import com.fkulesevic.movielicious.data.model.User
import com.fkulesevic.movielicious.firebase.EmptyRequestListener
import com.fkulesevic.movielicious.firebase.UserRequestListener
import com.fkulesevic.movielicious.firebase.database.DatabaseHelper
import javax.inject.Inject

class AuthenticationHelperImpl @Inject constructor(private val firebaseAuth: FirebaseAuth,
                                                   private val databaseHelper: DatabaseHelper) : AuthenticationHelper {

    override fun editUser(user: User, listener: UserRequestListener) {
        databaseHelper.saveUser(user)
        listener.onSuccessfulRequest(user)
    }

    override fun attemptToRegisterTheUser(email: String, password: String, name: String, listener: EmptyRequestListener) {
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val user = firebaseAuth.currentUser
                firebaseAuth.currentUser?.run {
                    val mappedUser = user?.mapToUser()
                    mappedUser?.userDisplayName = name
                    mappedUser?.let { databaseHelper.saveUser(it) }
                    listener.onSuccessfulRequest()
                }
            } else {
                listener.onFailedRequest()
            }
        }
    }

    override fun logTheUserIn(email: String, password: String, listener: UserRequestListener) {
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                firebaseAuth.currentUser?.run {
                    listener.onSuccessfulRequest(mapToUser())
                }
            } else {
                listener.onFailedRequest()
            }
        }
    }

    override fun setUserDisplayName(username: String) {
        val currentUser = firebaseAuth.currentUser
        val request = UserProfileChangeRequest.Builder().setDisplayName(username).build()
        currentUser?.updateProfile(request)?.addOnCompleteListener { }
    }

    override fun signInWithFacebook(credential: AuthCredential, listener: UserRequestListener) {
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener {
                    val user = getCurrentUser()?.mapToUser()
                    //TODO if(USER DOESNT EXIST) user?.let { databaseHelper.saveUser(it) }
                    user?.let { listener.onSuccessfulRequest(it) }

                }
    }

    override fun logTheUserOut() {
        firebaseAuth.signOut()
    }

    override fun checkIfUserIsLoggedIn(): Boolean = (firebaseAuth.currentUser != null)

    override fun getCurrentUserId(): String? = firebaseAuth.currentUser?.uid

    override fun getCurrentUser(): FirebaseUser? = (firebaseAuth.currentUser)
}
