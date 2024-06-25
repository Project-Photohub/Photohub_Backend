package com.example.photohub.security.authentication.vo

enum class Role(
    val level: Int
) {

    USER(1),

    MANAGER(2),

    ADMIN(3)
}