package com.fkulesevic.movielicious.presentation

import com.fkulesevic.movielicious.base.BasePresenter
import com.fkulesevic.movielicious.data.model.Movie
import com.fkulesevic.movielicious.ui.movies.views.NewFilmsView

interface NewFilmsPresenter : BasePresenter<NewFilmsView> {

    fun getMovies()

    fun loadNextPage(page: Int)

    fun onLikeTapped(movie: Movie)

    fun getFavorites()
}