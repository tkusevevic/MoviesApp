package com.tkusevic.moviesapp.firebase.database

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.tkusevic.moviesapp.data.model.Movie
import com.tkusevic.moviesapp.data.model.User
import javax.inject.Inject

/**
 * Created by tkusevic on 14.02.2018..
 */
class DatabaseHelperImpl @Inject constructor(private val reference: DatabaseReference) : DatabaseHelper {

    override fun saveUser(user: User) {
        reference.child("users").child(user.id).setValue(user)
    }

    override fun getUser(id: String, returningUser: (User) -> Unit) {
        reference.child("users").child(id).addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError?) {}

            override fun onDataChange(dataSnapshot: DataSnapshot?) {
                dataSnapshot?.run {
                    val user = getValue(User::class.java)
                    user?.run {
                        returningUser(user)
                    }
                }
            }
        })
    }

    override fun onMovieLiked(userId: String, movie: Movie) {
        val userMovies = reference.child("users").child(userId).child("movies").child(movie.id.toString())
        userMovies.setValue(if (!movie.isLiked) null else movie)
    }

    override fun listenToFavoriteMovies(userId: String, onFavoriteMoviesReceived: (List<Movie>) -> Unit) {
        reference.child("users").child(userId).child("movies").addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError?) {}

            override fun onDataChange(datasnapshot: DataSnapshot) {
                val values = if (datasnapshot.hasChildren()) datasnapshot.children.map { it.getValue(Movie::class.java) } else listOf()

                onFavoriteMoviesReceived(values.filterNotNull())
            }
        })
    }

    override fun getFavoriteMoviesOnce(userId: String, onFavoriteMoviesReceived: (List<Movie>) -> Unit) {
        reference.child("users").child(userId).child("movies").addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError?) {}

            override fun onDataChange(datasnapshot: DataSnapshot) {
                val values = if (datasnapshot.hasChildren()) datasnapshot.children.map { it.getValue(Movie::class.java) } else listOf<Movie>()
                onFavoriteMoviesReceived(values.filterNotNull())
            }

        })
    }


}