package com.fkulesevic.movielicious.firebase.database

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.fkulesevic.movielicious.data.model.Movie
import com.fkulesevic.movielicious.data.model.User
import javax.inject.Inject

class DatabaseHelperImpl @Inject constructor(private val reference: DatabaseReference) : DatabaseHelper {

    override fun saveUser(user: User) {
        reference.child("users").child(user.id).setValue(user)
    }

    override fun getUser(id: String, returningUser: (User) -> Unit) {
        reference.child("users").child(id).addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError?) {}

            override fun onDataChange(dataSnapshot: DataSnapshot?) {
                dataSnapshot?.run {
                    val user: User? = getValue(User::class.java)
                    user?.run {
                        returningUser(user)
                    }
                }
            }
        })
    }

    override fun addFavorites(userId: String, movies: List<Movie>) {
        movies.forEach { movie ->
            val userMovie = reference.child("users").child(userId).child("movies").child(movie.id.toString())
            userMovie.setValue(movie)
        }
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

    override fun getUsers(onUsersRecieved: (List<User>) -> Unit) {
        reference.child("users").addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onDataChange(data: DataSnapshot) {
                val values = if(data.hasChildren()) data.children.map { it.getValue(User::class.java) } else mutableListOf()
                onUsersRecieved(values.filterNotNull())
            }

            override fun onCancelled(p0: DatabaseError?) {}

        })
    }
}