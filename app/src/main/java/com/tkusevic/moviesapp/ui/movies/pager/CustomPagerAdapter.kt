package com.tkusevic.moviesapp.ui.movies.pager

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.ViewPager
import com.tkusevic.moviesapp.commons.constants.*

/**
 * Created by tkusevic on 16.02.2018..
 */
class CustomPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    private val fragments: MutableList<Fragment> = mutableListOf()

    fun addFragment(fragment: Fragment) {
        fragments.add(fragment)
        notifyDataSetChanged()
    }

    override fun getItem(position: Int): Fragment = fragments[position]

    override fun getCount(): Int = fragments.size

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> TOP_RATED
            1 -> NOW_PLAYING
            2 -> FAVORITES
            3 -> PROFILE
            else -> null
        }
    }
}