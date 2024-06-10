package com.example.photohub.usecase.photocard

import com.example.photohub.UseCase
import com.example.photohub.usecase.exception.BusinessException
import com.example.photohub.usecase.photocard.model.PhotoCardModelFactory
import com.example.photohub.usecase.photocard.port.`in`.LikePhotoCardUseCase
import com.example.photohub.usecase.photocard.port.out.persistence.FindPhotoCardPort
import com.example.photohub.usecase.photocard.port.out.persistence.SavePhotoCardPort
import java.util.*

@UseCase
class LikePhotoCardService(
    private val findPhotoCardPort: FindPhotoCardPort,
    private val savePhotoCardPort: SavePhotoCardPort,
    private val photoCardModelFactory: PhotoCardModelFactory
) : LikePhotoCardUseCase {

    override fun invoke(photoCardId: UUID) {

        val model = findPhotoCardPort.findById(photoCardId)
            ?: throw BusinessException.PHOTO_CARD_NOT_FOUND

        savePhotoCardPort.save(
            photoCardModelFactory.update(
                likeCount = model.getLikeCount() + 1,
                origin = model
            )
        )
    }
}