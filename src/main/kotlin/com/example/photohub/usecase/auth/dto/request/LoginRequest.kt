package com.example.photohub.usecase.auth.dto.request

import jakarta.validation.Valid
import jakarta.validation.constraints.Size
import org.jetbrains.annotations.NotNull

data class LoginRequest(

    @field:Valid
    @field:NotNull
    @field:Size(min = 2, max = 20)
    val id: String,

    @field:Valid
    @field:NotNull
    @field:Size(min = 5, max = 30)
    val password: String,
)
