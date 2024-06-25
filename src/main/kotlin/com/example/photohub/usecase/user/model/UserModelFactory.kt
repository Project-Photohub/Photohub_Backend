package com.example.photohub.usecase.user.model

import java.time.LocalDate

interface UserModelFactory {

    fun create(
        name: String,
        username: String,
        password: String,
        createdAt: LocalDate = LocalDate.now(),
        id: Long? = null
    ): UserModel
}