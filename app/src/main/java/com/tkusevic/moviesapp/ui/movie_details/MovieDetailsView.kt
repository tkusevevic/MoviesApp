package com.tkusevic.moviesapp.ui.movie_details

import com.tkusevic.moviesapp.data.model.Movie

/**
 * Created by tkusevic on 20.02.2018..
 */
interface MovieDetailsView {

    fun showData(movie: Movie)

    fun setLike(isLiked: Boolean)
}