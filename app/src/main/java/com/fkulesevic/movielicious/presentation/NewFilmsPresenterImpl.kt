package com.fkulesevic.movielicious.presentation

import com.fkulesevic.movielicious.commons.constants.NOW_PLAYING_KEY
import com.fkulesevic.movielicious.commons.constants.RESPONSE_OK
import com.fkulesevic.movielicious.data.model.Movie
import com.fkulesevic.movielicious.data.response.MoviesResponse
import com.fkulesevic.movielicious.firebase.MoviesRequestListener
import com.fkulesevic.movielicious.firebase.authentication.AuthenticationHelper
import com.fkulesevic.movielicious.firebase.database.DatabaseHelper
import com.fkulesevic.movielicious.interaction.MoviesInteractor
import com.fkulesevic.movielicious.ui.movies.views.NewFilmsView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class NewFilmsPresenterImpl @Inject constructor(private val moviesInteractor: MoviesInteractor,
                                                private val authenticationHelper: AuthenticationHelper,
                                                private val databaseHelper: DatabaseHelper) : MoviesRequestListener, NewFilmsPresenter {

    private lateinit var newFilmsView: NewFilmsView

    override fun setBaseview(baseView: NewFilmsView) {
        newFilmsView = baseView
    }

    override fun getMovies() = moviesInteractor.getMoviesBy(NOW_PLAYING_KEY, 1, getMoviesCallback())

    override fun getFavorites() {
        authenticationHelper.getCurrentUserId()?.run {
            databaseHelper.listenToFavoriteMovies(this, { onSuccessfulRequestMovies(it) })
        }
    }

    override fun onSuccessfulRequestMovies(movies: List<Movie>) = newFilmsView.setFavorites(movies)

    override fun onFailedRequestMovies() {
        //TODO couldn't load the new film Movies
    }

    private fun getMoviesCallback(): Callback<MoviesResponse> = object : Callback<MoviesResponse> {
        override fun onFailure(call: Call<MoviesResponse>?, t: Throwable?) {

        }

        override fun onResponse(call: Call<MoviesResponse>?, response: Response<MoviesResponse>) {
            if (response.isSuccessful) {
                if (response.code() == RESPONSE_OK) {
                    response.body()?.results.run { this?.let { onMoviesReceived(it) } }
                }
            }
        }
    }

    private fun onMoviesReceived(list: List<Movie>) {
        if (list.isEmpty()) {
            newFilmsView.showMessageEmptyList()
        } else {
            newFilmsView.hideMessageEmptyList()
        }
        newFilmsView.setMovies(list)

        authenticationHelper.getCurrentUserId()?.run {
            databaseHelper.getFavoriteMoviesOnce(this) { onSuccessfulRequestMovies(it) }
        }
    }

    override fun loadNextPage(page: Int) = moviesInteractor.loadNextPage(NOW_PLAYING_KEY, page, addMoviesCallback())

    private fun addMoviesCallback() = object : Callback<MoviesResponse> {
        override fun onResponse(call: Call<MoviesResponse>?, response: Response<MoviesResponse>) {
            if (response.isSuccessful) {
                if (response.code() == RESPONSE_OK)
                    response.body()?.results.run { this?.let { newFilmsView.addMovies(it) } }
            }
        }

        override fun onFailure(call: Call<MoviesResponse>?, t: Throwable?) {
            //TODO couldn't add nowPlaying movies
        }
    }

    override fun onLikeTapped(movie: Movie) {
        movie.isLiked = !movie.isLiked
        authenticationHelper.getCurrentUser()?.uid?.run {
            databaseHelper.onMovieLiked(this, movie)
        }
    }
}