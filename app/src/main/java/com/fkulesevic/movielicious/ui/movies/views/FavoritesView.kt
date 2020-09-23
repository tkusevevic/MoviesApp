package com.fkulesevic.movielicious.ui.movies.views

import com.fkulesevic.movielicious.data.model.Movie

interface FavoritesView {

    fun setMovies(movies: List<Movie>)

    fun showMessageOnScreen()

    fun hideMessageOnScreen()
}