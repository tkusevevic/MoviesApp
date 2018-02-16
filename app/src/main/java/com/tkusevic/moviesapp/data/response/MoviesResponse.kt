package com.tkusevic.moviesapp.data.response

import android.graphics.Movie
import com.google.gson.annotations.SerializedName

/**
 * Created by tkusevic on 15.02.2018..
 */
class MoviesResponse(val page : Int,
                     @SerializedName("total_pages")
                            val totalPages: Int,
                     val results : List<Movie>)