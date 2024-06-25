package com.example.photohub.usecase.auth.port.out

interface PasswordEncoder {

    operator fun invoke(rawPassword: String): String
}