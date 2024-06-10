package com.example.photohub.usecase.photocard.port.`in`

import com.example.photohub.usecase.photocard.dto.request.CreatePhotoCardWithImageUrlRequest

interface CreatePhotoCardWithImageUrlUseCase {

    operator fun invoke(request: CreatePhotoCardWithImageUrlRequest)
}