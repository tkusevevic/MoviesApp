package com.fkulesevic.movielicious.firebase.database

import com.fkulesevic.movielicious.data.model.Movie
import com.fkulesevic.movielicious.data.model.User

interface DatabaseHelper {

    fun saveUser(user: User)

    fun getUser(id: String, returningUser: (User) -> Unit)

    fun onMovieLiked(userId: String, movie: Movie)

    fun listenToFavoriteMovies(userId: String, onFavoriteMoviesReceived: (List<Movie>) -> Unit)

    fun getFavoriteMoviesOnce(userId: String, onFavoriteMoviesReceived: (List<Movie>) -> Unit)

    fun addFavorites(userId: String, movies: List<Movie>)

    fun getUsers( onUsersRecieved: (List<User>) -> Unit)
}