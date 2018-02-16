package com.tkusevic.moviesapp.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by tkusevic on 15.02.2018..
 */

class Movie(val id: Int,
            val homepage: String,
            @SerializedName("overview")
            var description: String,
            var popularity: Double,
            @SerializedName("poster_path")
            var imageUrl: String,
            @SerializedName("release_date")
            var release: String,
            var title: String)