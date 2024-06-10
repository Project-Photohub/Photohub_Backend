package com.example.photohub.usecase.photocard.port.`in`

import java.util.*

interface LikePhotoCardUseCase {

    operator fun invoke(photoCardId: UUID)
}