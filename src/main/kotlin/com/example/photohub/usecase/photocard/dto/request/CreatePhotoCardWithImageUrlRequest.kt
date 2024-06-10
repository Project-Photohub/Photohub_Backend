package com.example.photohub.usecase.photocard.dto.request

data class CreatePhotoCardWithImageUrlRequest(
    val name: String,
    val image: String,
    val backImage: String,
    val memberId: Long,
)
