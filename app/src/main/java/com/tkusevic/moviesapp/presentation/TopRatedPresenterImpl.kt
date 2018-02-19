package com.tkusevic.moviesapp.presentation

import com.tkusevic.moviesapp.interaction.MoviesInteractor
import com.tkusevic.moviesapp.ui.movies.views.TopRatedView
import javax.inject.Inject

/**
 * Created by tkusevic on 19.02.2018..
 */
class TopRatedPresenterImpl @Inject constructor(private val moviesInteractor: MoviesInteractor) : TopRatedPresenter {

    private lateinit var topRatedView: TopRatedView

    override fun setBaseview(baseView: TopRatedView) {
        this.topRatedView = baseView
    }

    override fun setTopRatedMovies() {

    }

}