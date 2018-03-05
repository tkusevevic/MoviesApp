package com.tkusevic.moviesapp.presentation

import com.tkusevic.moviesapp.commons.constants.API_KEY
import com.tkusevic.moviesapp.commons.constants.RESPONSE_OK
import com.tkusevic.moviesapp.commons.constants.TOP_RATED_KEY
import com.tkusevic.moviesapp.data.model.Movie
import com.tkusevic.moviesapp.data.response.MoviesResponse
import com.tkusevic.moviesapp.firebase.MoviesRequestListener
import com.tkusevic.moviesapp.firebase.authentication.AuthenticationHelper
import com.tkusevic.moviesapp.firebase.database.DatabaseHelper
import com.tkusevic.moviesapp.interaction.MoviesInteractor
import com.tkusevic.moviesapp.ui.search_movie.SearchMovieView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by tkusevic on 05.03.2018..
 */
class MovieSearchPresenterImpl @Inject constructor(private val moviesInteractor: MoviesInteractor,
                                                   private val authenticationHelper: AuthenticationHelper,
                                                   private val databaseHelper: DatabaseHelper) : MovieSearchPresenter, MoviesRequestListener {


    lateinit var view: SearchMovieView

    override fun setBaseview(baseView: SearchMovieView) {
        view = baseView
    }

    override fun getMovies(input: String) {
        moviesInteractor.searchMovies(input, 1, getMoviesCallback())
    }

    private fun getMoviesCallback(): Callback<MoviesResponse> = object : Callback<MoviesResponse> {
        override fun onFailure(call: Call<MoviesResponse>?, t: Throwable?) {
            //todo couldn't load movies
        }

        override fun onResponse(call: Call<MoviesResponse>?, response: Response<MoviesResponse>) {
            if (response.isSuccessful) {
                if (response.code() == RESPONSE_OK) {
                    response.body().results.run { onMoviesReceived(this) }
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

    override fun loadNextPage(input: String, page: Int) {
        moviesInteractor.loadNextPageSearch(input, page, addMoviesCallback())
    }

    private fun addMoviesCallback() = object : Callback<MoviesResponse> {
        override fun onResponse(call: Call<MoviesResponse>?, response: Response<MoviesResponse>) {
            if (response.isSuccessful) {
                if (response.code() == RESPONSE_OK)
                    response.body().results.run { view.addMovies(this) }
            }
        }

        override fun onFailure(call: Call<MoviesResponse>?, t: Throwable?) {
            // TODO couldn't load the top rated movies
        }
    }

    override fun clearList() {
        view.clearList()
    }

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