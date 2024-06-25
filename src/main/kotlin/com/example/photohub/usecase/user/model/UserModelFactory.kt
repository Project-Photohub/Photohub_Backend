package com.example.photohub.usecase.user.model

interface UserModelFactory {

    fun create(
        name: String,
        username: String,
        password: String
    ): UserModel
}