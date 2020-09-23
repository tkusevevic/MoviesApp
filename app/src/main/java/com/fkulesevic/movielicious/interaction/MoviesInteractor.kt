package com.fkulesevic.movielicious.interaction

import com.fkulesevic.movielicious.data.response.MoviesResponse
import retrofit2.Callback

interface MoviesInteractor {

    fun getMoviesBy(movieType: String, page: Int, moviesResponseCallback: Callback<MoviesResponse>)

    fun loadNextPage(type: String, page: Int, moviesResponseCallback: Callback<MoviesResponse>)

    fun searchMovies(input: String, page: Int, moviesResponseCallback: Callback<MoviesResponse>)

    fun loadNextPageSearch(input: String, page: Int, moviesResponseCallback: Callback<MoviesResponse>)
}