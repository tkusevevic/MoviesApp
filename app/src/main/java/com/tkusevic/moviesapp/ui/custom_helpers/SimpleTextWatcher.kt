package com.tkusevic.moviesapp.ui.custom_helpers

import android.text.Editable
import android.text.TextWatcher

/**
 * Created by tkusevic on 08.03.2018..
 */
class SimpleTextWatcher(private val onTextChanged: (String) -> Unit = {}) : TextWatcher {

    override fun afterTextChanged(s: Editable?) {}

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) = onTextChanged(s.toString())
}