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
class MoviesAdapter(private val listener: OnMovieClickListener) : RecyclerView.Adapter<MoviesViewHolder>() {

    private val movies: MutableList<Movie> = mutableListOf()

    fun setMovies(list: List<Movie>) {
        movies.clear()
        movies.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.holder_movies, parent, false)
        return MoviesViewHolder(listener, view)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movie = movies[position]
        holder.run {
            setMovie(movie)
            listener.let { this }
        }
    }

    override fun getItemCount(): Int = movies.size

    fun setMovieLiked(id: Int, isLiked: Boolean) {
        val movie = movies.find { it.id == id }

        movie?.run {
            this.isLiked = isLiked
            notifyItemChanged(movies.indexOf(this))
        }
    }
}