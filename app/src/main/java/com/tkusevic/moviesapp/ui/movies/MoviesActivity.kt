package com.tkusevic.moviesapp.ui.movies

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.tkusevic.moviesapp.R
import com.tkusevic.moviesapp.ui.movies.pager.CustomPagerAdapter
import kotlinx.android.synthetic.main.activity_movies.*
import android.support.v4.view.ViewPager
import android.view.MotionEvent
import android.view.View
import com.tkusevic.moviesapp.R.id.viewPager
import com.tkusevic.moviesapp.ui.movies.pager.NonSwipeableViewPager

/**
 * Created by tkusevic on 18.02.2018..
 */
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
        navigationPagerAdapter.addFragment(FavoritesFragment())
        navigationPagerAdapter.addFragment(ProfileFragment())

        viewPager.adapter = navigationPagerAdapter
        viewPager.offscreenPageLimit = 3

    }

    private fun initListeners() {
        bottomNavigation.setOnNavigationItemSelectedListener(
                { item ->
                    when (item.itemId) {
                        R.id.action_top_rated -> viewPager.currentItem = 0
                        R.id.action_now_playing -> viewPager.currentItem = 1
                        R.id.action_favorites -> viewPager.currentItem = 2
                        R.id.action_profile -> viewPager.currentItem = 3
                    }
                    true
                })
    }
}