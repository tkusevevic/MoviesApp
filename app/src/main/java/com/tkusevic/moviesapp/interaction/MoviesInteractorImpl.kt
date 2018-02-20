package com.tkusevic.moviesapp.interaction

import com.tkusevic.moviesapp.commons.constants.API_KEY
import com.tkusevic.moviesapp.data.response.MoviesResponse
import com.tkusevic.moviesapp.networking.MoviesApiService
import retrofit2.Callback
import javax.inject.Inject

/**
 * Created by tkusevic on 15.02.2018..
 */
class MoviesInteractorImpl @Inject constructor(private val service: MoviesApiService) : MoviesInteractor {

    override fun getMoviesBy(movieType: String, page: Int, moviesResponseCallback: Callback<MoviesResponse>) {
        service.getMoviesBy(movieType, API_KEY, page).enqueue(moviesResponseCallback)
    }

    override fun loadNextPage(type: String, page: Int, moviesResponseCallback: Callback<MoviesResponse>) {
        service.getMoviesBy(type, API_KEY, page).enqueue(moviesResponseCallback)
    }
}