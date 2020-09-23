package com.fkulesevic.movielicious.firebase

import com.fkulesevic.movielicious.data.model.Movie

interface MoviesRequestListener {

    fun onSuccessfulRequestMovies(movies: List<Movie>)

    fun onFailedRequestMovies()
}