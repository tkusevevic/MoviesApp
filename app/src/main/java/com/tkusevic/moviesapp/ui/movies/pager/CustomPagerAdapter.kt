package com.tkusevic.moviesapp.ui.movies.pager

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.tkusevic.moviesapp.commons.constants.FAVORITES
import com.tkusevic.moviesapp.commons.constants.LATEST
import com.tkusevic.moviesapp.commons.constants.PROFILE
import com.tkusevic.moviesapp.commons.constants.TOP_RATED

/**
 * Created by tkusevic on 16.02.2018..
 */
class CustomPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    val fragments: MutableList<Fragment> = mutableListOf()

    fun addFragment(fragment: Fragment) {
        fragments.add(fragment)
        notifyDataSetChanged()
    }

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> TOP_RATED
            1 -> LATEST
            2 -> FAVORITES
            3 -> PROFILE
            else -> null
        }
    }
}