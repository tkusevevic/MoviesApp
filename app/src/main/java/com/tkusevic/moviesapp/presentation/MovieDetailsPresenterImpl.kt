package com.tkusevic.moviesapp.presentation

import com.tkusevic.moviesapp.ui.movie_details.MovieDetailsView

/**
 * Created by tkusevic on 20.02.2018..
 */
class MovieDetailsPresenterImpl : MovieDetailsPresenter {

    private lateinit var movieDetailsView: MovieDetailsView

    override fun setBaseview(baseView: MovieDetailsView) {
        movieDetailsView = baseView
    }
}