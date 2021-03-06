package com.fkulesevic.movielicious.ui.movies.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.fkulesevic.movielicious.R
import com.fkulesevic.movielicious.data.model.Movie
import com.fkulesevic.movielicious.ui.listeners.OnMovieClickListener
import com.fkulesevic.movielicious.ui.movies.holder.MoviesViewHolder

class TopRatedNewFilmsAdapter(private val listener: OnMovieClickListener) : RecyclerView.Adapter<MoviesViewHolder>() {

    private val movies: MutableList<Movie> = mutableListOf()

    fun setMovies(list: List<Movie>) {
        movies.clear()
        movies.addAll(list)
        notifyDataSetChanged()
    }

    fun addMovies(movies: List<Movie>) {
        this.movies.addAll(movies)
        notifyDataSetChanged()
    }

    fun clearMovies() {
        movies.clear()
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

    fun setFavoriteMovies(favorite: List<Movie>) {
        val favoriteIds = favorite.map { it.id }
        movies.forEach { it.isLiked = it.id in favoriteIds }
        notifyDataSetChanged()
    }
}