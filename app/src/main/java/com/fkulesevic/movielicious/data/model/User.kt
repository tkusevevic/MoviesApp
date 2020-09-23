package com.fkulesevic.movielicious.data.model

import java.io.Serializable

data class User(val id: String = "",
                val email: String = "",
                var userDisplayName: String = "",
                var description: String = "",
                var moviesDescription: String = ""): Serializable