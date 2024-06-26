package com.example.photohub.usecase.group.dto.request

import jakarta.validation.Valid
import jakarta.validation.constraints.Positive
import org.jetbrains.annotations.NotNull

data class CreateMemberRequest(
    @Valid
    @NotNull
    val name: String,

    @Valid
    val nickname: String?,

    @Valid
    @Positive
    @NotNull
    val groupId: Long
)
