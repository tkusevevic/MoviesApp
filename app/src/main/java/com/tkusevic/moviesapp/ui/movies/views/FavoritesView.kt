package com.tkusevic.moviesapp.ui.movies.views

import com.tkusevic.moviesapp.data.model.Movie

/**
 * Created by tkusevic on 21.02.2018..
 */
interface FavoritesView {

    fun setMovies(movies: List<Movie>)
}