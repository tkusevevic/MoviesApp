package com.fkulesevic.movielicious.ui.movies.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import com.squareup.picasso.Picasso
import com.fkulesevic.movielicious.R
import com.fkulesevic.movielicious.commons.constants.IMAGE_BASE_URL
import com.fkulesevic.movielicious.commons.extensions.onClick
import com.fkulesevic.movielicious.data.model.Movie
import com.fkulesevic.movielicious.ui.listeners.OnMovieClickListener
import kotlinx.android.synthetic.main.holder_movies.view.*

class MoviesViewHolder(private val listener: OnMovieClickListener, itemView: View) : RecyclerView.ViewHolder(itemView) {


    fun setMovie(movie: Movie) = with(itemView) {
        if (movie.isLiked) {
            like.setImageResource(R.drawable.like_red_fill)
        } else {
            like.setImageResource(R.drawable.like_red)
        }
        Picasso.with(context)
                .load(IMAGE_BASE_URL + movie.imageUrl)
                .resize(720, 720)
                .centerCrop()
                .into(image)
        title.text = movie.title
        date.text = String.format("Released: %s", movie.release)
        rating.text = String.format("Rating: %s", movie.voteAverage)
        numberVotes.text = String.format("Number of votes: %s", movie.voteNumber)
        onClick { listener.onMovieClick(movie) }
        like.onClick { listener.onLikeClick(movie) }
    }
}