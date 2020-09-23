package com.fkulesevic.movielicious.data.response


import com.google.gson.annotations.SerializedName
import com.fkulesevic.movielicious.data.model.Movie

class MoviesResponse(val page: Int,
                     @SerializedName("total_pages")
                     val totalPages: Int,
                     val results: List<Movie>)