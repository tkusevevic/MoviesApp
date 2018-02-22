package com.tkusevic.moviesapp.presentation

import com.tkusevic.moviesapp.data.model.Movie
import com.tkusevic.moviesapp.firebase.authentication.AuthenticationHelper
import com.tkusevic.moviesapp.firebase.database.DatabaseHelper
import com.tkusevic.moviesapp.ui.movie_details.MovieDetailsView
import javax.inject.Inject

/**
 * Created by tkusevic on 20.02.2018..
 */
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