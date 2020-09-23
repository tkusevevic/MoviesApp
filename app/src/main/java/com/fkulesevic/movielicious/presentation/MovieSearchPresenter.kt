package com.fkulesevic.movielicious.presentation

import com.fkulesevic.movielicious.base.BasePresenter
import com.fkulesevic.movielicious.data.model.Movie
import com.fkulesevic.movielicious.ui.search_movie.SearchMovieView

interface MovieSearchPresenter : BasePresenter<SearchMovieView> {

    fun getMovies(input: String)

    fun loadNextPage(input: String, page: Int)

    fun onLikeTapped(movie: Movie)

    fun getFavorites()

    fun clearList()
}