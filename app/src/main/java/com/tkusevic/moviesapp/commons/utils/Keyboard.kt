package com.tkusevic.moviesapp.commons.utils

import android.app.Activity
import android.view.inputmethod.InputMethodManager

/**
 * Created by tkusevic on 27.02.2018..
 */
fun hideSoftKeyboard(activity: Activity) {
    val inputMethodManager = activity.getSystemService(
            Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(
            activity.currentFocus.windowToken, 0)
}