package com.fkulesevic.movielicious.presentation

import com.fkulesevic.movielicious.base.BasePresenter
import com.fkulesevic.movielicious.data.model.Movie
import com.fkulesevic.movielicious.ui.movie_details.MovieDetailsView

interface MovieDetailsPresenter : BasePresenter<MovieDetailsView> {

    fun onLikeTapped(movie: Movie)
}