package com.example.photohub.usecase.auth.port.out

interface PasswordComparer {

    fun isEqual(encodedPassword: String, password: String): Boolean
}