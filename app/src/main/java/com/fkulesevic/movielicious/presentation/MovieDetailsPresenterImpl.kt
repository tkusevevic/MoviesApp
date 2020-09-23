package com.fkulesevic.movielicious.presentation

import com.fkulesevic.movielicious.data.model.Movie
import com.fkulesevic.movielicious.firebase.authentication.AuthenticationHelper
import com.fkulesevic.movielicious.firebase.database.DatabaseHelper
import com.fkulesevic.movielicious.ui.movie_details.MovieDetailsView
import javax.inject.Inject

class MovieDetailsPresenterImpl @Inject constructor(private val authenticationHelper: AuthenticationHelper,
                                                    private val databaseHelper: DatabaseHelper) : MovieDetailsPresenter {

    private lateinit var movieDetailsView: MovieDetailsView

    override fun setBaseview(baseView: MovieDetailsView) {
        movieDetailsView = baseView
    }

    override fun onLikeTapped(movie: Movie) {
        movie.isLiked = !movie.isLiked
        authenticationHelper.getCurrentUser()?.uid?.run {
            databaseHelper.onMovieLiked(this, movie)
        }
        movieDetailsView.setLike(movie.isLiked)
    }
}