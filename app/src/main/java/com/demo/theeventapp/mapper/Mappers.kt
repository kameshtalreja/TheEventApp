package com.kamesh.newsapp.mapper

import com.demo.theeventapp.data.model.LoginDTO
import com.kamesh.newsapp.domain.model.Login

fun LoginDTO.toLogin() : Login {

    return Login(
            status = status,
        )

}