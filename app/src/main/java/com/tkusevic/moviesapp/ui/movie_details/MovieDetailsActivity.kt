package com.tkusevic.moviesapp.ui.movie_details

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.squareup.picasso.Picasso
import com.tkusevic.moviesapp.R
import com.tkusevic.moviesapp.commons.constants.IMAGE_KEY
import com.tkusevic.moviesapp.commons.constants.MOVIE_KEY
import com.tkusevic.moviesapp.commons.extensions.onClick
import com.tkusevic.moviesapp.data.model.Movie
import com.tkusevic.moviesapp.movieDetailsPresenter
import com.tkusevic.moviesapp.presentation.MovieDetailsPresenter
import com.tkusevic.moviesapp.presentation.MovieDetailsPresenterImpl
import kotlinx.android.synthetic.main.activity_movie_details.*
import java.io.Serializable

/**
 * Created by tkusevic on 20.02.2018..
 */
class MovieDetailsActivity : AppCompatActivity(), MovieDetailsView {

    private val presenter: MovieDetailsPresenter by lazy { movieDetailsPresenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        initPresenter()
        getMoviesInformation()
        initListeners()
    }

    private fun initListeners() {
        backDetails.onClick { finish() }
        likeMovieDetails.onClick {
            val intent = this.intent
            val bundle: Bundle = intent.extras
            val movie: Serializable? = bundle.getSerializable(MOVIE_KEY)
            presenter.onLikeTapped(movie as Movie) }
    }

    private fun initPresenter() {
        presenter.setBaseview(this)
    }

    private fun getMoviesInformation() {
        val intent = this.intent
        val bundle: Bundle = intent.extras
        val movie: Serializable? = bundle.getSerializable(MOVIE_KEY)
        showData(movie as Movie)
    }

    override fun showData(movie: Movie) {
        Picasso.with(this)
                .load(IMAGE_KEY + movie.imageUrl)
                .resize(180, 180)
                .centerCrop()
                .into(imageMovieDetails)

        if (movie.isLiked) {
            likeMovieDetails.setImageResource(R.drawable.like_fill)
        } else {
            likeMovieDetails.setImageResource(R.drawable.like)
        }
        titleMovieDetails.text = movie.title
        ratingMovieDetails.text = String.format("Rating: " + movie.voteAverage)
        numVotesMovieDetails.text = String.format("Vote Number: " + movie.voteNumber)
        descriptionMovieDetails.text = movie.description
    }

    override fun setLike(isLiked: Boolean) {
        if(isLiked) likeMovieDetails.setImageResource(R.drawable.like_fill)
        else likeMovieDetails.setImageResource(R.drawable.like)
    }
}