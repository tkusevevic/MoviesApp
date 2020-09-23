package com.fkulesevic.movielicious.ui.listeners

import com.fkulesevic.movielicious.data.model.Movie

interface OnMovieClickListener {

    fun onMovieClick(movie: Movie)

    fun onLikeClick(movie: Movie)
}