package com.fkulesevic.movielicious.interaction

import com.fkulesevic.movielicious.commons.constants.API_KEY
import com.fkulesevic.movielicious.data.response.MoviesResponse
import com.fkulesevic.movielicious.networking.MoviesApiService
import retrofit2.Callback
import javax.inject.Inject

class MoviesInteractorImpl @Inject constructor(private val service: MoviesApiService) : MoviesInteractor {

    override fun getMoviesBy(movieType: String, page: Int, moviesResponseCallback: Callback<MoviesResponse>) {
        service.getMoviesBy(movieType, API_KEY, page).enqueue(moviesResponseCallback)
    }

    override fun loadNextPage(type: String, page: Int, moviesResponseCallback: Callback<MoviesResponse>) {
        service.getMoviesBy(type, API_KEY, page).enqueue(moviesResponseCallback)
    }

    override fun searchMovies(input: String, page: Int, moviesResponseCallback: Callback<MoviesResponse>){
        service.getMoviesByText(input, API_KEY,page).enqueue(moviesResponseCallback)
    }

    override fun loadNextPageSearch(input: String, page: Int, moviesResponseCallback: Callback<MoviesResponse>) {
        service.getMoviesByText(input, API_KEY, page).enqueue(moviesResponseCallback)
    }
}