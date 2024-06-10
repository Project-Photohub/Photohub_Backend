package com.example.photohub.usecase.photocard.port.`in`

import com.example.photohub.usecase.photocard.dto.response.PhotoCardInfoListResponse

interface GetLatestPhotoCardUseCase {

    operator fun invoke(): PhotoCardInfoListResponse
}