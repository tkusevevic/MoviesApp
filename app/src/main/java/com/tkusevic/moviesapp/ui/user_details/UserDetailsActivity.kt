package com.tkusevic.moviesapp.ui.user_details

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.tkusevic.moviesapp.R
import com.tkusevic.moviesapp.commons.constants.USER_KEY
import com.tkusevic.moviesapp.commons.extensions.onClick
import com.tkusevic.moviesapp.data.model.Movie
import com.tkusevic.moviesapp.data.model.User
import com.tkusevic.moviesapp.ui.listeners.EndlessScrollListener
import com.tkusevic.moviesapp.ui.listeners.OnMovieClickListener
import com.tkusevic.moviesapp.ui.movies.adapter.TopRatedNewFilmsAdapter
import com.tkusevic.moviesapp.userDetailsPresenter
import kotlinx.android.synthetic.main.activity_other_user_details.*
import java.io.Serializable

class UserDetailsActivity : AppCompatActivity(), UserDetailsView , OnMovieClickListener{

    override fun onMovieClick(movie: com.tkusevic.moviesapp.data.model.Movie) {
    }

    override fun onLikeClick(movie: com.tkusevic.moviesapp.data.model.Movie) {
    }

    private val presenter by lazy { userDetailsPresenter() }

    private val adapter by lazy { TopRatedNewFilmsAdapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other_user_details)
        presenter.setBaseview(this)
        getUserInformation()
        initRecyclerView()
        initListeners()
    }

    private fun initListeners() {
        backDetails.onClick { finish() }
    }

    private fun getUserInformation() {
        val intent = this.intent
        val bundle: Bundle = intent.extras
        val movie: Serializable? = bundle.getSerializable(USER_KEY)
        showData(movie as User)
    }

    private fun showData(user: User) {
        profileEmail.text = user.email
        profileName.text = user.userDisplayName
        aboutMe.text = (user.description)
        profileMoviesDescription.text = user.moviesDescription
        presenter.getUserFavoriteMovies(user.id)
    }

    override fun setMovies(movies: List<Movie>) {
        adapter.setMovies(movies)
    }

    private fun initRecyclerView() {
        recyclerViewDetails.adapter = adapter
        val lm = LinearLayoutManager(this)
        recyclerViewDetails.layoutManager = lm
    }
}