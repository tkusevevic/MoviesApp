package com.fkulesevic.movielicious.di.module

import com.fkulesevic.movielicious.networking.MoviesApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@Singleton
class NetworkingModule {

    @Provides
    fun baseUrl(): String = "http://api.themoviedb.org/"

    @Provides
    fun loggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

    @Provides
    fun okHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient = OkHttpClient().newBuilder().addInterceptor(httpLoggingInterceptor).build()

    @Provides
    fun converterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    fun retrofit(client: OkHttpClient, baseUrl: String, gsonConverterFactory: GsonConverterFactory): Retrofit =
            Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(client)
                    .addConverterFactory(gsonConverterFactory)
                    .build()

    @Provides
    fun apiService(retrofit: Retrofit): MoviesApiService = retrofit.create(MoviesApiService::class.java)
}