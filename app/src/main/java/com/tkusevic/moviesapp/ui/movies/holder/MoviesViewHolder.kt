package com.tkusevic.moviesapp.ui.movies.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import com.tkusevic.moviesapp.data.model.Movie
import com.tkusevic.moviesapp.ui.listeners.OnMovieClickListener

/**
 * Created by tkusevic on 16.02.2018..
 */
class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var listener: OnMovieClickListener? = null

    fun setMovies(movie: Movie) {
        //TODO
    }

    fun setListener(listener: OnMovieClickListener) {
        this.listener = listener
    }
}