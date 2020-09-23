package com.fkulesevic.movielicious.ui.search_movie

import com.fkulesevic.movielicious.data.model.Movie

interface SearchMovieView {

    fun setMovies(movies: List<Movie>)

    fun addMovies(movies: List<Movie>)

    fun setFavorites(favorites: List<Movie>)

    fun clearList()
}