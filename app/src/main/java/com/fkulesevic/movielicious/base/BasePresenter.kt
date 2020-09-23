package com.fkulesevic.movielicious.base

interface BasePresenter<in T> {

    fun setBaseview(baseView: T)
}