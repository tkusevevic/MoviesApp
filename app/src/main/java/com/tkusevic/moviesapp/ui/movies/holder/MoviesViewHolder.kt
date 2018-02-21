package com.tkusevic.moviesapp.ui.movies.holder

import android.support.v7.widget.RecyclerView
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

    fun setMovie(movie: Movie) = with(itemView) {
        if (movie.isLiked) {
            like.setImageResource(R.drawable.like_fill)
        } else {
            like.setImageResource(R.drawable.like)
        }
        Picasso.with(context)
                .load(IMAGE_KEY + movie.imageUrl)
                .resize(720, 720)
                .centerCrop()
                .into(image)
        title.text = movie.title
        rating.text = String.format("Rating: %s", movie.voteAverage)
        numberVotes.text = String.format("Number of votes: %s", movie.voteNumber)
        onClick { listener.onMovieClick(movie) }
        like.onClick { listener.onLikeClick(movie) }
    }
}