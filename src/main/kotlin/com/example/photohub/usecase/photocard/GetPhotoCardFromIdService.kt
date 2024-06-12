package com.example.photohub.usecase.photocard

import com.example.photohub.ReadOnlyUseCase
import com.example.photohub.usecase.exception.BusinessException
import com.example.photohub.usecase.photocard.dto.response.PhotoCardMaximumInfoResponse
import com.example.photohub.usecase.photocard.port.`in`.GetPhotoCardFromIdUseCase
import com.example.photohub.usecase.photocard.port.out.persistence.FindPhotoCardPort
import java.util.*

@ReadOnlyUseCase
class GetPhotoCardFromIdService(
    private val findPhotoCardPort: FindPhotoCardPort
) : GetPhotoCardFromIdUseCase {

    override fun invoke(id: UUID): PhotoCardMaximumInfoResponse {
        val photoCard = findPhotoCardPort.findById(id)
            ?: throw BusinessException.PHOTO_CARD_NOT_FOUND

        return PhotoCardMaximumInfoResponse.of(photoCard)
    }
}