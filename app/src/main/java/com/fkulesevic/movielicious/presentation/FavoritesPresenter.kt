package com.fkulesevic.movielicious.presentation

import com.fkulesevic.movielicious.base.BasePresenter
import com.fkulesevic.movielicious.data.model.Movie
import com.fkulesevic.movielicious.ui.movies.views.FavoritesView

interface FavoritesPresenter : BasePresenter<FavoritesView> {

    fun getFavoriteMovies()

    fun onLikeTapped(movie: Movie)
}