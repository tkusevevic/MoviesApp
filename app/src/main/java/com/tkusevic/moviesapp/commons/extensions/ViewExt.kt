package com.tkusevic.moviesapp.commons.extensions

import android.app.Activity
import android.view.View
import android.view.inputmethod.InputMethodManager

/**
 * Created by tkusevic on 15.02.2018..
 */

fun View.onClick(onClick: () -> Unit) = setOnClickListener { onClick() }

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}