package com.example.photohub.usecase.auth.dto.request

data class SignupRequest(
    val id: String,
    val nickname: String,
    val password: String,
)
