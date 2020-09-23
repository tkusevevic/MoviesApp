package com.fkulesevic.movielicious.ui.movie_details

import com.fkulesevic.movielicious.data.model.Movie

interface MovieDetailsView {

    fun showData(movie: Movie)

    fun setLike(isLiked: Boolean)
}