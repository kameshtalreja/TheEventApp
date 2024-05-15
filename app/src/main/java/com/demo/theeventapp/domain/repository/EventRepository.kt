package com.kamesh.newsapp.domain.repository

import com.demo.theeventapp.domain.model.LoginRequest
import com.kamesh.newsapp.domain.model.Login


interface EventRepository {

    suspend fun login(body : LoginRequest) : Login
}