package com.fkulesevic.movielicious.ui.movies

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
import com.fkulesevic.movielicious.commons.extensions.hide
import com.fkulesevic.movielicious.commons.extensions.show
import com.fkulesevic.movielicious.data.model.Movie
import com.fkulesevic.movielicious.newFilmsPresenter
import com.fkulesevic.movielicious.presentation.NewFilmsPresenter
import com.fkulesevic.movielicious.ui.listeners.EndlessScrollListener
import com.fkulesevic.movielicious.ui.listeners.OnMovieClickListener
import com.fkulesevic.movielicious.ui.movie_details.MovieDetailsActivity
import com.fkulesevic.movielicious.ui.movies.adapter.TopRatedNewFilmsAdapter
import com.fkulesevic.movielicious.ui.movies.views.NewFilmsView
import kotlinx.android.synthetic.main.fragment_new_films.*

class NewFilmsFragment : Fragment(), OnMovieClickListener, NewFilmsView {

    private val presenter: NewFilmsPresenter by lazy { newFilmsPresenter() }

    private val adapter by lazy { TopRatedNewFilmsAdapter(this) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_new_films, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.setBaseview(this)
        loadFavorites()
        initRecyclerView()
        loadNewMovies()
    }

    private fun initRecyclerView() {
        recyclerViewNewFilms.adapter = adapter
        val lm = LinearLayoutManager(activity)
        recyclerViewNewFilms.layoutManager = lm
        val scrollListener = object : EndlessScrollListener(lm) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {
                presenter.loadNextPage(page)
            }
        }
        recyclerViewNewFilms.addOnScrollListener(scrollListener)
    }

    private fun loadFavorites() = presenter.getFavorites()

    private fun loadNewMovies() = presenter.getMovies()

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

    override fun setMovies(movies: List<Movie>) = adapter.setMovies(movies)

    override fun setFavorites(favorites: List<Movie>) = adapter.setFavoriteMovies(favorites)

    override fun showMessageEmptyList() = noNewMovies.show()

    override fun hideMessageEmptyList() = noNewMovies.hide()
}