package com.example.photohub.usecase.req.dto.request

import org.springframework.web.multipart.MultipartFile

data class CreateAddGroupReqRequest(
    val name: String,
    val logo: MultipartFile?,
    val members: List<MemberInfo>?
)

data class MemberInfo(
    val name: String,
    val nickname: String
)
