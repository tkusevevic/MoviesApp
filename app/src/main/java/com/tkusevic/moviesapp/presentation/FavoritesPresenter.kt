package com.tkusevic.moviesapp.presentation

import com.tkusevic.moviesapp.base.BasePresenter
import com.tkusevic.moviesapp.data.model.Movie
import com.tkusevic.moviesapp.ui.movies.views.FavoritesView

/**
 * Created by tkusevic on 21.02.2018..
 */
interface FavoritesPresenter : BasePresenter<FavoritesView> {

    fun getFavoriteMovies()

    fun onLikeTapped(movie: Movie)
}