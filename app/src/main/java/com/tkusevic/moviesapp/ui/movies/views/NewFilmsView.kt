package com.tkusevic.moviesapp.ui.movies.views

import com.tkusevic.moviesapp.data.model.Movie

/**
 * Created by tkusevic on 20.02.2018..
 */
interface NewFilmsView {

    fun setMovies(movies: List<Movie>)

    fun addMovies(movies: List<Movie>)
}