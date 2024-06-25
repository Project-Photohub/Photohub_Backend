package com.example.photohub.usecase.user.model

import com.example.photohub.security.authentication.vo.Role

interface UserModel {

    fun getName(): String

    fun getUsername(): String

    fun getPassword(): String

    fun getRole(): Role
}