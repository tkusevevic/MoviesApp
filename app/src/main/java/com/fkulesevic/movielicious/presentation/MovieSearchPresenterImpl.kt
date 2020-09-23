package com.fkulesevic.movielicious.presentation

import com.fkulesevic.movielicious.commons.constants.RESPONSE_OK
import com.fkulesevic.movielicious.data.model.Movie
import com.fkulesevic.movielicious.data.response.MoviesResponse
import com.fkulesevic.movielicious.firebase.MoviesRequestListener
import com.fkulesevic.movielicious.firebase.authentication.AuthenticationHelper
import com.fkulesevic.movielicious.firebase.database.DatabaseHelper
import com.fkulesevic.movielicious.interaction.MoviesInteractor
import com.fkulesevic.movielicious.ui.search_movie.SearchMovieView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MovieSearchPresenterImpl @Inject constructor(private val moviesInteractor: MoviesInteractor,
                                                   private val authenticationHelper: AuthenticationHelper,
                                                   private val databaseHelper: DatabaseHelper) : MovieSearchPresenter, MoviesRequestListener {

    private lateinit var view: SearchMovieView

    override fun setBaseview(baseView: SearchMovieView) {
        view = baseView
    }

    override fun getMovies(input: String) = moviesInteractor.searchMovies(input, 1, getMoviesCallback())

    private fun getMoviesCallback(): Callback<MoviesResponse> = object : Callback<MoviesResponse> {
        override fun onFailure(call: Call<MoviesResponse>?, t: Throwable?) {
            //todo couldn't load movies
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
        view.setMovies(list)
        authenticationHelper.getCurrentUserId()?.run {
            databaseHelper.getFavoriteMoviesOnce(this) { onSuccessfulRequestMovies(it) }
        }
    }

    override fun onSuccessfulRequestMovies(movies: List<Movie>) = view.setFavorites(movies)

    override fun onFailedRequestMovies() {
        //TODO FAILED FETCH
    }

    override fun loadNextPage(input: String, page: Int) = moviesInteractor.loadNextPageSearch(input, page, addMoviesCallback())

    private fun addMoviesCallback() = object : Callback<MoviesResponse> {
        override fun onResponse(call: Call<MoviesResponse>?, response: Response<MoviesResponse>) {
            if (response.isSuccessful) {
                if (response.code() == RESPONSE_OK)
                    response.body()?.results.run { this?.let { view.addMovies(it) } }
            }
        }

        override fun onFailure(call: Call<MoviesResponse>?, t: Throwable?) {
            // TODO couldn't load the top rated movies
        }
    }

    override fun clearList() = view.clearList()

    override fun onLikeTapped(movie: Movie) {
        movie.isLiked = !movie.isLiked
        authenticationHelper.getCurrentUser()?.uid?.run {
            databaseHelper.onMovieLiked(this, movie)
        }
    }

    override fun getFavorites() {
        authenticationHelper.getCurrentUserId()?.run {
            databaseHelper.listenToFavoriteMovies(this, { onSuccessfulRequestMovies(it) })
        }
    }
}