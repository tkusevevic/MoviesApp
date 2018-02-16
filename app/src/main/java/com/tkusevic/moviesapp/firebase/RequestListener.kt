package com.tkusevic.moviesapp.firebase

/**
 * Created by tkusevic on 14.02.2018..
 */
interface RequestListener {
    fun onSuccessfulRequest()

    fun onFailedRequest()
}