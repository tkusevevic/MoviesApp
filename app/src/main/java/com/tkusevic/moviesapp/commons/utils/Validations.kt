package com.tkusevic.moviesapp.commons.utils

import com.tkusevic.moviesapp.commons.constants.EMAIL_REGEX
import java.util.regex.Pattern


/**
 * Created by tkusevic on 14.02.2018..
 */


fun isValidEmail(input: String?): Boolean {
    return Pattern.matches(EMAIL_REGEX, input)
}

fun checkEmailEmpty(email: String): Boolean {
    return email.isEmpty()
}

fun checkPasswordEmpty(password: String): Boolean {
    return password.isEmpty()
}

fun checkNameEmpty(name: String): Boolean {
    return name.isEmpty()
}

