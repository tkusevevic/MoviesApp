package com.tkusevic.moviesapp.data.response


import com.google.gson.annotations.SerializedName
import com.tkusevic.moviesapp.data.model.Movie

/**
 * Created by tkusevic on 15.02.2018..
 */
class MoviesResponse(val page: Int,
                     @SerializedName("total_pages")
                     val totalPages: Int,
                     val results: List<Movie>)