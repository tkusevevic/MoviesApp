package com.tkusevic.moviesapp.interaction

import com.tkusevic.moviesapp.data.response.MoviesResponse
import retrofit2.Callback

/**
 * Created by tkusevic on 15.02.2018..
 */
interface MoviesInteractor {
    fun getMoviesBy(movieType: String, page: Int, moviesResponseCallback: Callback<MoviesResponse>)

    fun loadNextPage(type: String, page: Int, moviesResponseCallback: Callback<MoviesResponse>)
}