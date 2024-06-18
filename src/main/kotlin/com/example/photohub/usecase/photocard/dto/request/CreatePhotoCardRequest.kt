package com.example.photohub.usecase.photocard.dto.request

import org.springframework.web.multipart.MultipartFile

data class CreatePhotoCardRequest(
    val image: MultipartFile,
    val backImage: MultipartFile,
    val name: String,
    val memberId: Long,
)
