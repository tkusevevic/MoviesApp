package com.tkusevic.moviesapp.data.model


/**
 * Created by tkusevic on 14.02.2018..
 */
data class User(val id: String = "",
                val email: String = "",
                var userDisplayName: String = "",
                var description: String = "",
                var moviesDescription: String = "")