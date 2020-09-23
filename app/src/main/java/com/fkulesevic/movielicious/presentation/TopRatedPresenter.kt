package com.fkulesevic.movielicious.presentation

import com.fkulesevic.movielicious.base.BasePresenter
import com.fkulesevic.movielicious.data.model.Movie
import com.fkulesevic.movielicious.ui.movies.views.TopRatedView

interface TopRatedPresenter : BasePresenter<TopRatedView> {

    fun getMovies()

    fun getFavorites()

    fun loadNextPage(page: Int)

    fun onLikeTapped(movie: Movie)
}