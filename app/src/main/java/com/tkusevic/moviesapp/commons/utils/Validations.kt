package com.tkusevic.moviesapp.commons.utils

import com.tkusevic.moviesapp.App
import com.tkusevic.moviesapp.R
import kotlinx.android.synthetic.main.activity_registration.*
import java.util.*


/**
 * Created by tkusevic on 14.02.2018..
 */

fun isPasswordCorrect(password: String): Boolean {
    return password.length < 6 && !password.isEmpty()
}

fun inputsNotEmpty(email: String, password: String, name: String): Boolean {
    return (!email.isEmpty() && !password.isEmpty() && !name.isEmpty())
}

fun checkEmailEmpty(email : String) : Boolean {
    return email.isEmpty()
}

fun checkPasswordEmpty(password: String) : Boolean {
    return password.isEmpty()
}

fun checkNameEmpty(name : String) : Boolean {
    return name.isEmpty()
}

