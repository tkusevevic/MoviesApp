package com.tkusevic.moviesapp.ui.search_movie

import com.tkusevic.moviesapp.data.model.Movie

/**
 * Created by tkusevic on 05.03.2018..
 */
interface SearchMovieView {

    fun setMovies(movies: List<Movie>)

    fun addMovies(movies: List<Movie>)

    fun setFavorites(favorites : List<Movie>)

    fun clearList()
}