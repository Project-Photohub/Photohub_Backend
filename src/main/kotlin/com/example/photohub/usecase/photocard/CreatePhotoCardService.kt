package com.example.photohub.usecase.photocard

import com.example.photohub.UseCase
import com.example.photohub.usecase.exception.BusinessException
import com.example.photohub.usecase.global.file.port.out.UploadFileToCloudPort
import com.example.photohub.usecase.group.port.out.persistence.FindMemberPort
import com.example.photohub.usecase.photocard.dto.request.CreatePhotoCardRequest
import com.example.photohub.usecase.photocard.model.PhotoCardModelFactory
import com.example.photohub.usecase.photocard.port.`in`.CreatePhotoCardUseCase
import com.example.photohub.usecase.photocard.port.out.persistence.SavePhotoCardPort
import com.example.photohub.usecase.user.port.out.GetCurrentUserPort

@UseCase
class CreatePhotoCardService(
    private val findMemberPort: FindMemberPort,
    private val uploadFileToCloudPort: UploadFileToCloudPort,
    private val photoCardModelFactory: PhotoCardModelFactory,
    private val savePhotoCardPort: SavePhotoCardPort,
    private val getCurrentUserPort: GetCurrentUserPort
) : CreatePhotoCardUseCase {

    companion object {
        val allowedFileTypes = listOf("image/jpg", "image/png", "image/jpeg", "image/heic")
    }

    override fun invoke(req: CreatePhotoCardRequest) {

        if (!allowedFileTypes.contains(req.image.contentType) ||
            !allowedFileTypes.contains(req.backImage.contentType)
        ) {
            throw BusinessException(400, "File Type Not Allowed")
        }

        val member = findMemberPort.findById(req.memberId)
            ?: throw BusinessException.MEMBER_NOT_FOUND

        val uploadedImageUrl = uploadFileToCloudPort(req.image)
        val uploadedBackImageUrl = uploadFileToCloudPort(req.backImage)

        val model = req.run {
            photoCardModelFactory.create(
                name = name,
                image = uploadedImageUrl,
                backImage = uploadedBackImageUrl,
                member = member,
                uploader = getCurrentUserPort()
            )
        }

        savePhotoCardPort.save(model)
    }
}