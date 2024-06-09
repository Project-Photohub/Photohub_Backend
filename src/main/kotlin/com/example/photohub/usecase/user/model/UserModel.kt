package com.example.photohub.usecase.user.model

@Deprecated(message = "유저 관련 기능이 제거됨")
interface UserModel {

    fun getName(): String

    fun getUsername(): String

    fun getPassword(): String
}