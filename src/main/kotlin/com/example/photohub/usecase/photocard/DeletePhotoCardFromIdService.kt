package com.example.photohub.usecase.photocard

import com.example.photohub.UseCase
import com.example.photohub.security.authentication.vo.Role
import com.example.photohub.usecase.exception.BusinessException
import com.example.photohub.usecase.exception.SecurityException
import com.example.photohub.usecase.global.file.port.out.DeleteFilePort
import com.example.photohub.usecase.photocard.port.`in`.DeletePhotoCardFromIdUseCase
import com.example.photohub.usecase.photocard.port.out.persistence.DeletePhotoCardPort
import com.example.photohub.usecase.photocard.port.out.persistence.FindPhotoCardPort
import com.example.photohub.usecase.user.port.out.GetCurrentUserPort
import java.util.*

@UseCase
class DeletePhotoCardFromIdService(
    private val findPhotoCardPort: FindPhotoCardPort,
    private val deletePhotoCardPort: DeletePhotoCardPort,
    private val deleteFilePort: DeleteFilePort,
    private val getCurrentUserPort: GetCurrentUserPort,
) : DeletePhotoCardFromIdUseCase {

    override fun invoke(id: UUID) {

        val photoCard = findPhotoCardPort.findById(id)
            ?: throw BusinessException.PHOTO_CARD_NOT_FOUND

        if (photoCard.getUploader().getUsername() != getCurrentUserPort().getUsername() &&
            getCurrentUserPort().getRole() < Role.MANAGER
        ) {
            throw SecurityException.FORBIDDEN
        }

        deletePhotoCardPort.deleteById(id)

        deleteFilePort.deleteFile(
            photoCard.getImageUrl()
        )

        deleteFilePort.deleteFile(
            photoCard.getBackImageUrl()
        )
    }
}