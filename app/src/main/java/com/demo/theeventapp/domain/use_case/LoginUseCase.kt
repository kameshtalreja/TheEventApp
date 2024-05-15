package com.kamesh.newsapp.domain.use_case

import com.demo.theeventapp.domain.model.LoginRequest
import com.kamesh.newsapp.domain.model.Login
import com.kamesh.newsapp.domain.repository.EventRepository
import com.kamesh.newsapp.util.Resources
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val eventRepository: EventRepository) {

    operator fun invoke(loginRequest: LoginRequest) : Flow<Resources<Login>> = flow {

        emit(Resources.Loading())

        try {
            emit(Resources.Success(eventRepository.login(loginRequest)))
        } catch (e : Exception){
          emit(Resources.Error(e.message))
        }

    }
}