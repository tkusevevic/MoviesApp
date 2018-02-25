package com.tkusevic.moviesapp.ui.movies.views

import com.tkusevic.moviesapp.data.model.Movie

/**
 * Created by tkusevic on 19.02.2018..
 */
interface TopRatedView {

    fun setMovies(movies: List<Movie>)

    fun addMovies(movies: List<Movie>)

    fun setFavorites(favorites : List<Movie>)

    fun showMessageEmptyList()

    fun hideMessageEmptyList()
}