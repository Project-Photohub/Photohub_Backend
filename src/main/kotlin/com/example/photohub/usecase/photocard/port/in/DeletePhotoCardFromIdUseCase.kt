package com.example.photohub.usecase.photocard.port.`in`

import java.util.*

interface DeletePhotoCardFromIdUseCase {

    operator fun invoke(id: UUID)
}