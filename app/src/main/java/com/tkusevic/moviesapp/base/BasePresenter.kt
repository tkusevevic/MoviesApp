package com.tkusevic.moviesapp.base

/**
 * Created by tkusevic on 14.02.2018..
 */
interface BasePresenter<in T> {

    fun setBaseview(baseView: T)
}