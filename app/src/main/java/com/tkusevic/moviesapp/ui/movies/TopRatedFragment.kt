package com.tkusevic.moviesapp.ui.movies

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
import com.tkusevic.moviesapp.data.model.Movie
import com.tkusevic.moviesapp.presentation.TopRatedPresenter
import com.tkusevic.moviesapp.topRatedPresenter
import com.tkusevic.moviesapp.ui.listeners.EndlessScrollListener
import com.tkusevic.moviesapp.ui.listeners.OnMovieClickListener
import com.tkusevic.moviesapp.ui.movie_details.MovieDetailsActivity
import com.tkusevic.moviesapp.ui.movies.adapter.MoviesAdapter
import com.tkusevic.moviesapp.ui.movies.views.TopRatedView
import kotlinx.android.synthetic.main.fragment_top_rated.*

/**
 * Created by tkusevic on 18.02.2018..
 */
class TopRatedFragment : Fragment(), OnMovieClickListener, TopRatedView {

    private val presenter: TopRatedPresenter by lazy { topRatedPresenter() }

    private val adapter by lazy { MoviesAdapter(this) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_top_rated, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.setBaseview(this)
        initRecyclerView()
        loadTopRatedMovies()
    }

    private fun initRecyclerView() {
        recyclerViewTopRated.adapter = adapter
        val lm = LinearLayoutManager(activity)
        recyclerViewTopRated.layoutManager = lm
        val scrollListener = object : EndlessScrollListener(lm) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {
                presenter.loadNextPage(page)
            }
        }
        recyclerViewTopRated.addOnScrollListener(scrollListener)
    }

    private fun loadTopRatedMovies() = presenter.getMovies()

    override fun addMovies(movies: List<Movie>) = adapter.addMovies(movies)

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

}

