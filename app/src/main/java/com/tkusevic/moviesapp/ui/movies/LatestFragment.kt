package com.tkusevic.moviesapp.ui.movies

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tkusevic.moviesapp.R
import com.tkusevic.moviesapp.data.model.Movie
import com.tkusevic.moviesapp.ui.listeners.OnMovieClickListener
import com.tkusevic.moviesapp.ui.movies.adapter.MoviesAdapter

/**
 * Created by tkusevic on 18.02.2018..
 */
class LatestFragment : Fragment(), OnMovieClickListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_lates_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = MoviesAdapter()
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