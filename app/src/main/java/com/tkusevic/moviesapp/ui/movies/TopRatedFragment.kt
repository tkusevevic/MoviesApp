package com.tkusevic.moviesapp.ui.movies

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tkusevic.moviesapp.R
import com.tkusevic.moviesapp.data.model.Movie
import com.tkusevic.moviesapp.presentation.TopRatedPresenter
import com.tkusevic.moviesapp.topRatedPresenter
import com.tkusevic.moviesapp.ui.listeners.OnMovieClickListener
import com.tkusevic.moviesapp.ui.movies.views.TopRatedView

/**
 * Created by tkusevic on 18.02.2018..
 */
class TopRatedFragment : Fragment(), OnMovieClickListener, TopRatedView {

    private val presenter: TopRatedPresenter by lazy { topRatedPresenter() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_top_rated, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    private fun initAdapter() {
        //TODO
    }

    override fun onMovieClick(movie: Movie) {
        //TODO
    }

    override fun onLikeClick(movies: Movie) {
        //TODO
    }
}