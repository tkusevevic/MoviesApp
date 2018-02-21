package com.tkusevic.moviesapp.commons.extensions

import android.content.Context
import android.widget.Toast
import com.google.firebase.auth.FirebaseUser
import com.tkusevic.moviesapp.data.model.User

/**
 * Created by tkusevic on 15.02.2018..
 */

fun Context?.toast(message: String) {
    this?.let { Toast.makeText(this, message, Toast.LENGTH_SHORT).show() }
}

fun FirebaseUser.mapToUser(): User = User(this.uid,
        this.email ?: "", this.displayName ?: "", "","")