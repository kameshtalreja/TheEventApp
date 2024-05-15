package com.kamesh.newsapp.presentation.viewmodel

import com.kamesh.newsapp.domain.model.Login

data class LoginStateHolder(
    val isLoading : Boolean = false,
    val data : Login? = null,
    val error : String = ""
    )
