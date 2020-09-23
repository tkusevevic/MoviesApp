package com.fkulesevic.movielicious.di

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface Repository {

    fun baseUrl(): String

    fun retrofit(client: OkHttpClient, baseUrl: String, gsonConverterFactory: GsonConverterFactory): Retrofit

    fun loggingInterceptor(): HttpLoggingInterceptor

    fun okHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient
}