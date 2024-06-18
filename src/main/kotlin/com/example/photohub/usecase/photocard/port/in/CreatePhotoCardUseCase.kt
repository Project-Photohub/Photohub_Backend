package com.example.photohub.usecase.photocard.port.`in`

import com.example.photohub.usecase.photocard.dto.request.CreatePhotoCardRequest

interface CreatePhotoCardUseCase {

    operator fun invoke(req: CreatePhotoCardRequest)
}