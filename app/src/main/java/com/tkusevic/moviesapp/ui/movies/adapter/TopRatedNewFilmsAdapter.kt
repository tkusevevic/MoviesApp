package com.tkusevic.moviesapp.ui.movies.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.tkusevic.moviesapp.R
import com.tkusevic.moviesapp.data.model.Movie
import com.tkusevic.moviesapp.ui.listeners.OnMovieClickListener
import com.tkusevic.moviesapp.ui.movies.holder.TopRatedNewFilmsViewHolder

/**
 * Created by tkusevic on 22.02.2018..
 */

class TopRatedNewFilmsAdapter(private val listener: OnMovieClickListener) : RecyclerView.Adapter<TopRatedNewFilmsViewHolder>() {

    private val movies: MutableList<Movie> = mutableListOf()

    fun setMovies(list: List<Movie>) {
        movies.clear()
        movies.addAll(list)
        notifyDataSetChanged()
    }

    fun addMovies(movies: List<Movie> = arrayListOf()) {
        val start: Int = this.movies.size
        this.movies.addAll(movies)
        notifyItemRangeInserted(start, movies.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopRatedNewFilmsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.holder_movies, parent, false)
        return TopRatedNewFilmsViewHolder(listener, view)
    }

    override fun onBindViewHolder(holder: TopRatedNewFilmsViewHolder?, position: Int) {
        val movie = movies[position]
        holder?.run {
            setMovie(movie)
            listener.let { this }
        }
    }

    override fun getItemCount(): Int =  movies.size

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