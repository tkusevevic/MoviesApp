package com.fkulesevic.movielicious.ui.search_movie

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fkulesevic.movielicious.R
import com.fkulesevic.movielicious.commons.constants.MOVIE_KEY
import com.fkulesevic.movielicious.commons.extensions.onClick
import com.fkulesevic.movielicious.commons.extensions.onTextChange
import com.fkulesevic.movielicious.data.model.Movie
import com.fkulesevic.movielicious.movieSearchPresenter
import com.fkulesevic.movielicious.presentation.MovieSearchPresenter
import com.fkulesevic.movielicious.ui.listeners.EndlessScrollListener
import com.fkulesevic.movielicious.ui.listeners.OnMovieClickListener
import com.fkulesevic.movielicious.ui.movie_details.MovieDetailsActivity
import com.fkulesevic.movielicious.ui.movies.adapter.TopRatedNewFilmsAdapter
import kotlinx.android.synthetic.main.activity_search_movies.*

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