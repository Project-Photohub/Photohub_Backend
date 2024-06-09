package com.example.photohub.usecase.user.model

import java.time.LocalDate

@Deprecated(message = "유저 관련 기능이 제거됨")
interface UserModelFactory {

    fun create(
        name: String,
        username: String,
        password: String,
        createdAt: LocalDate = LocalDate.now(),
        id: Long? = null
    ): UserModel
}