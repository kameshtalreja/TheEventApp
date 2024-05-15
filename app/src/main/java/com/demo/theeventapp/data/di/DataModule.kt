package com.kamesh.newsapp.data.di

import com.kamesh.newsapp.data.remote.EventApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun getNewsApi() : EventApi {
        return Retrofit.Builder()
            .baseUrl("https://ldb-me.ve-live.com/api/AdminApiProvider/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(EventApi::class.java)
    }
}