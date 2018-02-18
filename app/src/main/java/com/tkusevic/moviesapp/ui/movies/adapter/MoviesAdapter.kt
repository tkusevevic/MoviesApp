package com.tkusevic.moviesapp.ui.movies.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.tkusevic.moviesapp.R
import com.tkusevic.moviesapp.data.model.Movie
import com.tkusevic.moviesapp.ui.listeners.OnMovieClickListener
import com.tkusevic.moviesapp.ui.movies.holder.MoviesViewHolder

/**
 * Created by tkusevic on 18.02.2018..
 */
class MoviesAdapter : RecyclerView.Adapter<MoviesViewHolder>() {

    private var listener: OnMovieClickListener? = null

    private val movies: MutableList<Movie> = mutableListOf()

    fun setListener(listener: OnMovieClickListener) {
        this.listener = listener
    }

    fun setMovies(list: List<Movie>) {
        movies.clear()
        movies.addAll(list)
        notifyDataSetChanged()
    }

    fun addMovie(movie: Movie) {
        movies.add(movie)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movie = movies[position]
        holder.run {
            setMovies(movie)
            listener?.let { setListener(it) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.holder_movies, parent, false)
        return MoviesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}