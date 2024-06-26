package com.example.photohub.usecase.group.dto.request

import org.springframework.web.multipart.MultipartFile

data class CreateGroupRequest(
    val name: String,
    val logo: MultipartFile
)
