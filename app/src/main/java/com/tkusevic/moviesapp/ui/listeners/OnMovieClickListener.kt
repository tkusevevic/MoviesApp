package com.tkusevic.moviesapp.ui.listeners

import com.tkusevic.moviesapp.data.model.Movie

/**
 * Created by tkusevic on 18.02.2018..
 */
interface OnMovieClickListener {

    fun onMovieClick(movie: Movie)

    fun onLikeClick(movie: Movie)
}