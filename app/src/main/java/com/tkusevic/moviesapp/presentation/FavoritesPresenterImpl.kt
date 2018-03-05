package com.tkusevic.moviesapp.presentation

import com.tkusevic.moviesapp.data.model.Movie
import com.tkusevic.moviesapp.firebase.MoviesRequestListener
import com.tkusevic.moviesapp.firebase.authentication.AuthenticationHelper
import com.tkusevic.moviesapp.firebase.database.DatabaseHelper
import com.tkusevic.moviesapp.ui.movies.views.FavoritesView
import javax.inject.Inject

/**
 * Created by tkusevic on 21.02.2018..
 */
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