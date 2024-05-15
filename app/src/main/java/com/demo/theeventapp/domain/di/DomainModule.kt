package com.kamesh.newsapp.domain.di

import com.kamesh.newsapp.data.remote.EventApi
import com.kamesh.newsapp.data.repository.EventRepositoryImpl
import com.kamesh.newsapp.domain.repository.EventRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DomainModule {
    @Provides
    @Singleton
    fun provideGetNewsRepo(api: EventApi) : EventRepository{
        return EventRepositoryImpl(api)
    }
}