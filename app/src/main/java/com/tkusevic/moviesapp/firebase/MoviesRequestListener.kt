package com.tkusevic.moviesapp.firebase

import com.tkusevic.moviesapp.data.model.Movie
import com.tkusevic.moviesapp.data.model.User
/**
 * Created by tkusevic on 21.02.2018..
 */
interface MoviesRequestListener {

    fun onSuccessfulRequestMovies(movies: List<Movie>)

    fun onFailedRequestMovies()
}