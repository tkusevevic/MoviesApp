package com.tkusevic.moviesapp.firebase

import com.tkusevic.moviesapp.data.model.Movie
import com.tkusevic.moviesapp.data.model.User

/**
 * Created by tkusevic on 25.02.2018..
 */
interface MovieAndUserRequest {

    fun onSuccessfulRequest(movies: MutableList<Movie>,user: User)

    fun onFailedRequest()
}