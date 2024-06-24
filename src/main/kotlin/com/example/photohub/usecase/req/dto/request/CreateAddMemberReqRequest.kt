package com.example.photohub.usecase.req.dto.request

data class CreateAddMemberReqRequest(
    val groupId: Long,
    val name: String,
    val nickname: String?
)
