package com.fkulesevic.movielicious.networking

import com.fkulesevic.movielicious.data.response.MoviesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesApiService {

    @GET("3/movie/{movieType}/")
    fun getMoviesBy(@Path("movieType") movieType: String, @Query("api_key") apiKey: String, @Query("page") page: Int):
            Call<MoviesResponse>

    @GET("3/search/movie/")
    fun getMoviesByText( @Query("query") query: String, @Query("api_key") apiKey: String, @Query("page") page: Int): Call<MoviesResponse>
}