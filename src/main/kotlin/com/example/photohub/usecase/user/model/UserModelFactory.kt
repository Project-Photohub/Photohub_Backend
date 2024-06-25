package com.example.photohub.usecase.user.model

import com.example.photohub.security.authentication.vo.Role

interface UserModelFactory {

    fun create(
        name: String,
        username: String,
        password: String,
        role: Role = Role.USER
    ): UserModel
}