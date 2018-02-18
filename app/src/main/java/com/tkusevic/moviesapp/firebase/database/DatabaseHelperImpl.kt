package com.tkusevic.moviesapp.firebase.database

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.tkusevic.moviesapp.data.model.User

/**
 * Created by tkusevic on 14.02.2018..
 */
class DatabaseHelperImpl : DatabaseHelper {

    val reference = FirebaseDatabase.getInstance().reference

    override fun saveUser(user: User) {
        Log.d("USER REGISTRATION", reference.root.toString())
        reference.child("users").child(user.id).setValue(user)
    }

    override fun getUser(id: String, returningUser: (User) -> Unit) {
        reference.child("users").child(id).addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError?) {

            }

            override fun onDataChange(dataSnapshot: DataSnapshot?) {
                dataSnapshot?.run {
                    val user = getValue(User::class.java)
                    user?.run {
                        Log.d("User", toString())
                        returningUser(user)
                    }
                }
            }
        })

    }


    override fun editUser(user: User) {
        //TODO
    }

}