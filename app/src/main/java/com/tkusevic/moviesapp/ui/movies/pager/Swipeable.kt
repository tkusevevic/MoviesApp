package com.tkusevic.moviesapp.ui.movies.pager

import android.content.Context
import android.view.MotionEvent
import android.support.v4.view.ViewPager
import android.util.AttributeSet


/**
 * Created by tkusevic on 26.02.2018..
 */
class Swipeable : ViewPager {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean = false

    override fun onTouchEvent(event: MotionEvent): Boolean = false
}