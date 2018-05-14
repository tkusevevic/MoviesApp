package com.tkusevic.moviesapp.di

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by tkusevic on 05.04.2018..
 */
interface Repository {

    fun baseUrl(): String

    fun retrofit(client: OkHttpClient, baseUrl: String, gsonConverterFactory: GsonConverterFactory): Retrofit

    fun loggingInterceptor(): HttpLoggingInterceptor

    fun okHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient
}