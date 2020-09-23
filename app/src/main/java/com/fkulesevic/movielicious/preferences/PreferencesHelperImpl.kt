package com.fkulesevic.movielicious.preferences

import android.content.SharedPreferences
import com.fkulesevic.movielicious.commons.constants.PREFS_USER_ID_KEY
import javax.inject.Inject

class PreferencesHelperImpl @Inject constructor(private val preferences: SharedPreferences) : PreferencesHelper {

    override fun getId(): String = preferences.getString(PREFS_USER_ID_KEY, "")

    override fun removeId() = preferences.edit().clear().apply()

    override fun saveId(userId: String) = preferences.edit().putString(PREFS_USER_ID_KEY, userId).apply()

    override fun userIdExists(): Boolean = getId().isNotBlank()
}