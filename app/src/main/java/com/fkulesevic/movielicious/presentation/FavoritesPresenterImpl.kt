package com.fkulesevic.movielicious.presentation

import com.fkulesevic.movielicious.data.model.Movie
import com.fkulesevic.movielicious.firebase.MoviesRequestListener
import com.fkulesevic.movielicious.firebase.authentication.AuthenticationHelper
import com.fkulesevic.movielicious.firebase.database.DatabaseHelper
import com.fkulesevic.movielicious.ui.movies.views.FavoritesView
import javax.inject.Inject

class FavoritesPresenterImpl @Inject constructor(private val authenticationHelper: AuthenticationHelper,
                                                 private val database: DatabaseHelper) : FavoritesPresenter, MoviesRequestListener {

    private lateinit var favoritesView: FavoritesView

    override fun setBaseview(baseView: FavoritesView) {
        this.favoritesView = baseView
    }

    override fun getFavoriteMovies() {
        val userId = authenticationHelper.getCurrentUserId()
        userId?.let { database.listenToFavoriteMovies(it, { this.onSuccessfulRequestMovies(it) }) }
    }

    override fun onSuccessfulRequestMovies(movies: List<Movie>) {
        if (movies.isEmpty()) {
            favoritesView.showMessageOnScreen()
        } else {
            favoritesView.hideMessageOnScreen()
        }
        favoritesView.setMovies(movies)
    }

    override fun onFailedRequestMovies() {
        //TODO couldn't load favorites movies
    }

    override fun onLikeTapped(movie: Movie) {
        movie.isLiked = !movie.isLiked
        authenticationHelper.getCurrentUser()?.uid?.run {
            database.onMovieLiked(this, movie)
        }
    }
}