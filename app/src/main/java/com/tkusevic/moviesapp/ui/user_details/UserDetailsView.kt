package com.tkusevic.moviesapp.ui.user_details

import com.tkusevic.moviesapp.data.model.Movie


interface UserDetailsView {

    fun setMovies(movies : List<Movie>)
}