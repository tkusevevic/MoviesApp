package com.tkusevic.moviesapp.preferences

import android.content.SharedPreferences
import com.tkusevic.moviesapp.commons.constants.PREFS_USER_ID_KEY
import javax.inject.Inject

/**
 * Created by tkusevic on 27.02.2018..
 */
class PreferencesHelperImpl @Inject constructor(private val preferences: SharedPreferences) : PreferencesHelper {

    override fun getId(): String = preferences.getString(PREFS_USER_ID_KEY, "")

    override fun removeId() = preferences.edit().clear().apply()

    override fun saveId(userId: String) = preferences.edit().putString(PREFS_USER_ID_KEY, userId).apply()

    override fun userIdExists(): Boolean = getId().isNotBlank()
}