package com.tkusevic.moviesapp.presentation

import com.tkusevic.moviesapp.base.BasePresenter
import com.tkusevic.moviesapp.data.model.Movie
import com.tkusevic.moviesapp.ui.movie_details.MovieDetailsView

/**
 * Created by tkusevic on 20.02.2018..
 */
interface MovieDetailsPresenter : BasePresenter<MovieDetailsView> {

    fun onLikeTapped(movie: Movie)
}