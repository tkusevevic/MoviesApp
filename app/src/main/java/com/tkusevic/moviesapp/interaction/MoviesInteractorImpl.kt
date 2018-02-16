package com.tkusevic.moviesapp.interaction

import com.tkusevic.moviesapp.commons.constants.API_KEY
import com.tkusevic.moviesapp.data.response.MoviesResponse
import com.tkusevic.moviesapp.networking.MoviesApiService

/**
 * Created by tkusevic on 15.02.2018..
 */
class MoviesInteractorImpl(private val service: MoviesApiService) : MoviesInteractor {

    override fun getMoviesBy(movieType: String, page: Int, moviesResponseCallback: retrofit2.Callback<MoviesResponse>) {
        service.getMoviesBy(movieType, API_KEY, page).enqueue(moviesResponseCallback)
    }
}