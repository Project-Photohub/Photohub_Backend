package com.example.photohub.usecase.photocard.port.`in`

import com.example.photohub.usecase.photocard.dto.response.PhotoCardInfoListResponse

interface GetRandomPhotoCardUseCase {

    operator fun invoke(): PhotoCardInfoListResponse
}