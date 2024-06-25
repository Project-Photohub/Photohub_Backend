package com.example.photohub.security.authentication.annotation

import com.example.photohub.security.authentication.vo.Role

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
annotation class RequireRole(
    val role: Role
)
