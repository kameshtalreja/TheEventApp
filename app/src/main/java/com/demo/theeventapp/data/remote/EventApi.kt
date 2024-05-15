package com.kamesh.newsapp.data.remote

import com.demo.theeventapp.data.model.LoginDTO
import com.demo.theeventapp.domain.model.LoginRequest
import com.kamesh.newsapp.domain.model.Login
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface EventApi {


    @POST("UserLogin")
    suspend fun login(
        @Body body: LoginRequest
    ) : Response<LoginDTO>
}