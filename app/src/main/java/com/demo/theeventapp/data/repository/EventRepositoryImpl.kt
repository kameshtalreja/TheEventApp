package com.kamesh.newsapp.data.repository

import com.demo.theeventapp.domain.model.LoginRequest
import com.kamesh.newsapp.data.remote.EventApi
import com.kamesh.newsapp.domain.model.Login
import com.kamesh.newsapp.domain.repository.EventRepository
import com.kamesh.newsapp.mapper.toLogin
import com.kamesh.newsapp.util.SafeApiRequest
import javax.inject.Inject

class EventRepositoryImpl @Inject constructor(
    private val newsApi: EventApi
) : EventRepository, SafeApiRequest(){


    override suspend fun login(body: LoginRequest): Login {
        val response = safeApiRequest { newsApi.login(body) }
        return response.toLogin()
    }


}