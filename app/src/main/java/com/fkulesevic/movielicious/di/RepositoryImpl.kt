package com.fkulesevic.movielicious.di

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RepositoryImpl : Repository {

    override fun baseUrl(): String = "http://api.themoviedb.org/"

    override fun loggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

    override fun okHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient = OkHttpClient().newBuilder().addInterceptor(httpLoggingInterceptor).build()

    override fun retrofit(client: OkHttpClient, baseUrl: String, gsonConverterFactory: GsonConverterFactory): Retrofit =
            Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(client)
                    .addConverterFactory(gsonConverterFactory)
                    .build()


}