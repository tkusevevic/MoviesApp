package com.tkusevic.moviesapp.networking

import com.tkusevic.moviesapp.data.response.MoviesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


/**
 * Created by tkusevic on 14.02.2018..
 */
interface MoviesApiService {
    //https://api.themoviedb.org/3/movie/popular?api_key=ff96a52eda935e86cbf75ecd8b6cf4a1&language=en-US&page=1

    @GET("3/movie/{movieType}/")
    fun getMoviesBy(@Path("movieType") movieType: String, @Query("api_key") apiKey: String, @Query("page") page : Int) :
            Call<MoviesResponse>

}