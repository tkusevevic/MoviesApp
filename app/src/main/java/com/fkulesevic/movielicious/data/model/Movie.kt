package com.fkulesevic.movielicious.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Movie(val id: Int = 0,
            val homepage: String = "",
            var isLiked: Boolean = false,
            @SerializedName("overview")
            var description: String = "",
            var popularity: Double = 0.0,
            @SerializedName("poster_path")
            var imageUrl: String = "",
            @SerializedName("release_date")
            var release: String = "",
            @SerializedName("vote_count")
            var voteNumber: String = "",
            @SerializedName("vote_average")
            var voteAverage: String = "",
            var title: String = ""): Serializable