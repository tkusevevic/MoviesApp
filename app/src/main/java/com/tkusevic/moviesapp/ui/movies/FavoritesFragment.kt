package com.tkusevic.moviesapp.ui.movies

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tkusevic.moviesapp.R
import com.tkusevic.moviesapp.commons.constants.MOVIE_KEY
import com.tkusevic.moviesapp.commons.extensions.hide
import com.tkusevic.moviesapp.commons.extensions.show
import com.tkusevic.moviesapp.data.model.Movie
import com.tkusevic.moviesapp.favoritesPresenter
import com.tkusevic.moviesapp.presentation.FavoritesPresenter
import com.tkusevic.moviesapp.ui.listeners.OnMovieClickListener
import com.tkusevic.moviesapp.ui.movie_details.MovieDetailsActivity
import com.tkusevic.moviesapp.ui.movies.adapter.MoviesAdapter
import com.tkusevic.moviesapp.ui.movies.views.FavoritesView
import kotlinx.android.synthetic.main.fragment_favorites.*

/**
 * Created by tkusevic on 18.02.2018..
 */
class FavoritesFragment : Fragment(), OnMovieClickListener, FavoritesView {

    private val presenter: FavoritesPresenter by lazy { favoritesPresenter() }

    private val adapter by lazy { MoviesAdapter(this) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initPresenter()
        initRecycler()
        loadFavorites()
    }

    private fun initPresenter() = presenter.setBaseview(this)

    private fun initRecycler() {
        recyclerViewFavorites.adapter = adapter
        val lm = LinearLayoutManager(activity)
        recyclerViewFavorites.layoutManager = lm
    }

    private fun loadFavorites() = presenter.getFavoriteMovies()

    override fun setMovies(movies: List<Movie>) = adapter.setMovies(movies)

    override fun onMovieClick(movie: Movie) {
        val bundle = Bundle()
        bundle.putSerializable(MOVIE_KEY, movie)
        val intent = Intent(activity, MovieDetailsActivity::class.java).putExtras(bundle)
        startActivity(intent)
    }

    override fun onLikeClick(movie: Movie) {
        presenter.onLikeTapped(movie)
        adapter.setMovieLiked(movie.id, movie.isLiked)
    }

    override fun showMessageOnScreen() = noFavorites.show()

    override fun hideMessageOnScreen() = noFavorites.hide()
}