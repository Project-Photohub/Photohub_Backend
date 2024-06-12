package com.example.photohub.usecase.photocard.port.`in`

import com.example.photohub.usecase.photocard.dto.response.PhotoCardMaximumInfoResponse
import java.util.*

interface GetPhotoCardFromIdUseCase {

    operator fun invoke(id: UUID): PhotoCardMaximumInfoResponse
}