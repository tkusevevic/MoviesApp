package com.fkulesevic.movielicious.ui.movies

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.fkulesevic.movielicious.R
import com.fkulesevic.movielicious.ui.movies.pager.CustomPagerAdapter
import com.fkulesevic.movielicious.ui.search_movie.SearchFragment
import kotlinx.android.synthetic.main.activity_movies.*

class MoviesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)
        initAdapter()
        initListeners()
    }

    private fun initAdapter() {
        val navigationPagerAdapter = CustomPagerAdapter(supportFragmentManager)
        navigationPagerAdapter.addFragment(TopRatedFragment())
        navigationPagerAdapter.addFragment(NewFilmsFragment())
        navigationPagerAdapter.addFragment(SearchFragment())
        navigationPagerAdapter.addFragment(FavoritesFragment())

        viewPager.adapter = navigationPagerAdapter
        viewPager.offscreenPageLimit = 4

    }

    private fun initListeners() {
        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_top_rated -> viewPager.currentItem = 0
                R.id.action_now_playing -> viewPager.currentItem = 1
                R.id.action_search -> viewPager.currentItem = 2
                R.id.action_favorites -> viewPager.currentItem = 3
            }
            true
        }
    }
}