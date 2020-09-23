package com.fkulesevic.movielicious.ui.movies.views

import com.fkulesevic.movielicious.data.model.Movie

interface TopRatedView {

    fun setMovies(movies: List<Movie>)

    fun addMovies(movies: List<Movie>)

    fun setFavorites(favorites : List<Movie>)

    fun showMessageEmptyList()

    fun hideMessageEmptyList()

}