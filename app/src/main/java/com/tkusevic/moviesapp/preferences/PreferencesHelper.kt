package com.tkusevic.moviesapp.preferences

/**
 * Created by tkusevic on 27.02.2018..
 */
interface PreferencesHelper {

    fun getId() : String

    fun removeId()

    fun saveId(userId: String)

    fun userIdExists() : Boolean
}