package com.tkusevic.moviesapp.presentation

import com.tkusevic.moviesapp.commons.constants.NOW_PLAYING_KEY
import com.tkusevic.moviesapp.commons.constants.RESPONSE_OK
import com.tkusevic.moviesapp.data.model.Movie
import com.tkusevic.moviesapp.data.response.MoviesResponse
import com.tkusevic.moviesapp.interaction.MoviesInteractor
import com.tkusevic.moviesapp.ui.movies.views.NewFilmsView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by tkusevic on 20.02.2018..
 */
class NewFilmsPresenterImpl @Inject constructor(private val moviesInteractor: MoviesInteractor) : NewFilmsPresenter {

    private lateinit var newFilmsView: NewFilmsView

    override fun setBaseview(baseView: NewFilmsView) {
        newFilmsView = baseView
    }

    override fun getMovies() {
        moviesInteractor.getMoviesBy(NOW_PLAYING_KEY, 1, getMoviesCallback())
    }

    private fun getMoviesCallback(): Callback<MoviesResponse> = object : Callback<MoviesResponse> {
        override fun onFailure(call: Call<MoviesResponse>?, t: Throwable?) {

        }

        override fun onResponse(call: Call<MoviesResponse>?, response: Response<MoviesResponse>) {
            if (response.isSuccessful) {
                if (response.code() == RESPONSE_OK) {
                    response.body().results.run { newFilmsView.setMovies(this) }
                }
            }
        }
    }

    override fun loadNextPage(page: Int) {
        moviesInteractor.loadNextPage(NOW_PLAYING_KEY, page, addBeersCallback())
    }

    private fun addBeersCallback() = object : Callback<MoviesResponse> {
        override fun onResponse(call: Call<MoviesResponse>?, response: Response<MoviesResponse>) {
            if (response.isSuccessful) {
                if (response.code() == RESPONSE_OK)
                    response.body().results.run { newFilmsView.addMovies(this) }
            }
        }

        override fun onFailure(call: Call<MoviesResponse>?, t: Throwable?) {

        }
    }

    override fun onLikeTapped(movie: Movie) {
        //movie.isLiked = !movie.isLiked
        //authenticationHelper.getCurrentUser()?.uid?.run {
        //    databaseHelper.onMovieLiked(this, movie)
        //}
    }
}