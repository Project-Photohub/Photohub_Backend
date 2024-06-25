package com.example.photohub.security.password

import com.example.photohub.usecase.auth.port.out.PasswordComparer
import com.example.photohub.usecase.auth.port.out.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class PasswordManager(
    private val passwordEncoder: org.springframework.security.crypto.password.PasswordEncoder
) : PasswordComparer, PasswordEncoder {

    override fun isEqual(encodedPassword: String, password: String): Boolean =
        passwordEncoder.matches(encodedPassword, password)

    override fun invoke(rawPassword: String): String =
        passwordEncoder.encode(rawPassword)
}