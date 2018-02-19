package com.tkusevic.moviesapp.ui.movies

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v7.app.AppCompatActivity
import com.tkusevic.moviesapp.R
import com.tkusevic.moviesapp.commons.constants.FAVORITES
import com.tkusevic.moviesapp.commons.constants.LATEST
import com.tkusevic.moviesapp.commons.constants.PROFILE
import com.tkusevic.moviesapp.commons.constants.TOP_RATED
import com.tkusevic.moviesapp.ui.movies.pager.CustomPagerAdapter
import kotlinx.android.synthetic.main.activity_movies.*

/**
 * Created by tkusevic on 18.02.2018..
 */
class MoviesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)
        initTabs()
        initAdapter()
        initListeners()
    }

    private fun initTabs() {
        tabLayout.addTab(tabLayout.newTab().setText(TOP_RATED))
        tabLayout.addTab(tabLayout.newTab().setText(LATEST))
        tabLayout.addTab(tabLayout.newTab().setText(FAVORITES))
        tabLayout.addTab(tabLayout.newTab().setText(PROFILE))
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL
    }

    private fun initAdapter() {
        val navigationPagerAdapter = CustomPagerAdapter(supportFragmentManager)
        navigationPagerAdapter.addFragment(TopRatedFragment())
        navigationPagerAdapter.addFragment(LatestFragment())
        navigationPagerAdapter.addFragment(FavoritesFragment())
        navigationPagerAdapter.addFragment(ProfileFragment())

        viewPager.adapter = navigationPagerAdapter

    }

    private fun initListeners() {
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}

            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
    }
}