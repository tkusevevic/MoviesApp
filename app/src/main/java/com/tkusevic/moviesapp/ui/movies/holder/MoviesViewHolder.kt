package com.tkusevic.moviesapp.ui.movies.holder

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import com.squareup.picasso.Picasso
import com.tkusevic.moviesapp.R
import com.tkusevic.moviesapp.commons.constants.IMAGE_KEY
import com.tkusevic.moviesapp.commons.extensions.onClick
import com.tkusevic.moviesapp.data.model.Movie
import com.tkusevic.moviesapp.ui.listeners.OnMovieClickListener
import kotlinx.android.synthetic.main.holder_movies.view.*

/**
 * Created by tkusevic on 16.02.2018..
 */
class MoviesViewHolder(private val listener: OnMovieClickListener, itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun setMovies(movie: Movie) = with(itemView) {
        if(movie.isLiked){
            itemView.like.setImageResource(R.drawable.like_fill)
        }
        Picasso.with(context)
                .load(IMAGE_KEY + movie.imageUrl)
                .resize(110, 110)
                .centerCrop()
                .into(image)
        itemView.title.text = movie.title
        itemView.rating.text =String.format("Rating: %s",movie.voteAverage)
        onClick { listener.onMovieClick(movie) }
        itemView.like.onClick { listener.onLikeClick(movie) }

    }

}