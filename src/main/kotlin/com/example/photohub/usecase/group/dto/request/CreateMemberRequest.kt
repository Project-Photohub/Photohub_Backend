package com.example.photohub.usecase.group.dto.request

data class CreateMemberRequest(
    val name: String,
    val nickname: String,
    val groupId: Long
)
