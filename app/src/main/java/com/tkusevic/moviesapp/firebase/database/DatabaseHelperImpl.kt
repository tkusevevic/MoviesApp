package com.tkusevic.moviesapp.firebase.database

import android.util.Log
import com.google.firebase.database.FirebaseDatabase
import com.tkusevic.moviesapp.data.model.User

/**
 * Created by tkusevic on 14.02.2018..
 */
class DatabaseHelperImpl : DatabaseHelper {

    val reference = FirebaseDatabase.getInstance()

    override fun saveUser(user: User) {
        Log.d("USER REGISTRATION", reference.reference.root.toString())
        reference.reference.child("users").child(user.id).setValue(user)
    }

    override fun getUser(id: String): User {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun editUser(user: User) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}