package com.tkusevic.moviesapp.commons.constants

/**
 * Created by tkusevic on 15.02.2018..
 */

const val API_KEY = "ff96a52eda935e86cbf75ecd8b6cf4a1"

//registration request
const val SUCCESS_REGISTRATION = "Successful registration!"
const val FAILED_REGISRATION = "Failed registration!"

//registration errors
const val PASSWORD_ERROR = "Password must contains 6 or more characters!"
const val EMAIL_ERROR = "Incorrect email!"
const val NO_NAME_ERROR = "Name is empty!"
const val ERROR_EMAIL_OR_PASSWORD = "Wrong input of email or password"

//pager titles
const val TOP_RATED = "Top rated"
const val NOW_PLAYING = "Now playing"
const val FAVORITES = "Favorites"
const val PROFILE = "Profile"
const val SEARCH = "Search"

//key for downloading image
const val IMAGE_KEY = "https://image.tmdb.org/t/p/w500"

//keys for activities
const val TOP_RATED_KEY = "top_rated"
const val NOW_PLAYING_KEY = "now_playing"
const val MOVIE_KEY = "movie"

//responses
const val RESPONSE_OK = 200

//shared preferences
const val PREFS_USER_ID_KEY = "userId"
const val PREFS_NAME = "AppPrefs"

//FACEBOOK
const val FACEBOOK_EMAIL = "email"
const val FACEBOOK_PROFILE = "public_profile"
const val FACEBOOK_TEXT = "FACEBOOK"

//Errors
const val NO_USER_ERROR = "Couldn't load user :("
const val FACEBOOK_ERROR = "Couldn't sign you in with Facebook :("

//email regex
const val EMAIL_REGEX = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])"


