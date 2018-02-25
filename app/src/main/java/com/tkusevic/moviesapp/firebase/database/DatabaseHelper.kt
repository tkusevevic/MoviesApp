package com.tkusevic.moviesapp.firebase.database

import com.tkusevic.moviesapp.data.model.Movie
import com.tkusevic.moviesapp.data.model.User

/**
 * Created by tkusevic on 14.02.2018..
 */
interface DatabaseHelper {

    fun saveUser(user: User)

    fun getUser(id: String, returningUser: (User) -> Unit)

    fun onMovieLiked(userId: String, movie: Movie)

    fun listenToFavoriteMovies(userId: String, onFavoriteMoviesReceived: (List<Movie>) -> Unit)

    fun getFavoriteMoviesOnce(userId: String, onFavoriteMoviesReceived: (List<Movie>) -> Unit)
}