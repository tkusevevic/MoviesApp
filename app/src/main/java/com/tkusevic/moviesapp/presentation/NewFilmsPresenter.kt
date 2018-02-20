package com.tkusevic.moviesapp.presentation

import com.tkusevic.moviesapp.base.BasePresenter
import com.tkusevic.moviesapp.ui.movies.views.NewFilmsView

/**
 * Created by tkusevic on 20.02.2018..
 */
interface NewFilmsPresenter : BasePresenter<NewFilmsView>{

    fun getMovies()

    fun loadNextPage(page: Int)
}