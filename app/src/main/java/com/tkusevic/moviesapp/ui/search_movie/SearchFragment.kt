package com.tkusevic.moviesapp.ui.search_movie

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tkusevic.moviesapp.R
import com.tkusevic.moviesapp.commons.constants.MOVIE_KEY
import com.tkusevic.moviesapp.commons.extensions.onClick
import com.tkusevic.moviesapp.commons.extensions.onTextChange
import com.tkusevic.moviesapp.data.model.Movie
import com.tkusevic.moviesapp.movieSearchPresenter
import com.tkusevic.moviesapp.presentation.MovieSearchPresenter
import com.tkusevic.moviesapp.ui.listeners.EndlessScrollListener
import com.tkusevic.moviesapp.ui.listeners.OnMovieClickListener
import com.tkusevic.moviesapp.ui.movie_details.MovieDetailsActivity
import com.tkusevic.moviesapp.ui.movies.adapter.TopRatedNewFilmsAdapter
import kotlinx.android.synthetic.main.activity_search_movies.*

/**
 * Created by tkusevic on 07.03.2018..
 */
class SearchFragment : Fragment(), OnMovieClickListener, SearchMovieView {

    private val adapter by lazy { TopRatedNewFilmsAdapter(this) }

    private val presenter: MovieSearchPresenter by lazy { movieSearchPresenter() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.activity_search_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.setBaseview(this)
        initRecyclerView()
        initListener()
    }

    private fun initListener() {
        clearSearch.onClick {
            searchInput.text.clear()
            presenter.clearList()
        }

        searchInput.onTextChange {
            presenter.getMovies(searchInput.text.toString())
            if (searchInput.text.toString().isEmpty() || searchInput.text.toString().isBlank()) {
                presenter.clearList()
            }
        }
    }

    private fun initRecyclerView() {
        recyclerViewSearch.adapter = adapter
        val lm = LinearLayoutManager(activity)
        recyclerViewSearch.layoutManager = lm
        val scrollListener = object : EndlessScrollListener(lm) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {
                presenter.loadNextPage(searchInput.text.toString(), page)
            }
        }
        recyclerViewSearch.addOnScrollListener(scrollListener)
    }

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

    override fun addMovies(movies: List<Movie>) = adapter.addMovies(movies)

    override fun setFavorites(favorites: List<Movie>) = adapter.setFavoriteMovies(favorites)

    override fun clearList() = adapter.clearMovies()
}