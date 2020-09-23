package com.fkulesevic.movielicious.preferences

interface PreferencesHelper {

    fun getId() : String

    fun removeId()

    fun saveId(userId: String)

    fun userIdExists() : Boolean
}