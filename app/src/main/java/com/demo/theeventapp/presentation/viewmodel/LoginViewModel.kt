package com.kamesh.newsapp.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.theeventapp.domain.model.LoginRequest
import com.kamesh.newsapp.domain.use_case.LoginUseCase
import com.kamesh.newsapp.util.Resources
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel(){

    private  val TAG = "LoginViewModel"

    val loginResponse = mutableStateOf(LoginStateHolder())

    init {
//        loginEvent()
    }

    fun loginEvent(userEmail: String?, userPassword: String?) {
        loginUseCase(LoginRequest(
               "testEmail@gmail.com",
             "testPassword")).onEach {

            Log.d(TAG, "loginEvent: $it")
            when(it){
                is Resources.Loading -> {
                    loginResponse.value = LoginStateHolder(isLoading = true)
                }
                is Resources.Error -> {
                    loginResponse.value = LoginStateHolder(error = it.message.toString())
                }
                is Resources.Success -> {
                    loginResponse.value = LoginStateHolder(data = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }

}