package com.tkusevic.moviesapp.presentation

import com.tkusevic.moviesapp.base.BasePresenter
import com.tkusevic.moviesapp.data.model.Movie
import com.tkusevic.moviesapp.ui.search_movie.SearchMovieView

/**
 * Created by tkusevic on 05.03.2018..
 */
interface MovieSearchPresenter : BasePresenter<SearchMovieView> {

    fun getMovies(input: String)

    fun loadNextPage( input: String,page: Int)

    fun onLikeTapped(movie: Movie)

    fun getFavorites()

    fun clearList()
}