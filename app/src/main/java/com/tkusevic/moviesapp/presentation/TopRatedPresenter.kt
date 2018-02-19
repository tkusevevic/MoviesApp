package com.tkusevic.moviesapp.presentation

import com.tkusevic.moviesapp.base.BasePresenter
import com.tkusevic.moviesapp.ui.movies.views.TopRatedView

/**
 * Created by tkusevic on 19.02.2018..
 */
interface TopRatedPresenter : BasePresenter<TopRatedView> {

    fun setTopRatedMovies()
}