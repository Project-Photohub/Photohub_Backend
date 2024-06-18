package com.example.photohub.usecase.photocard

import com.example.photohub.UseCase
import com.example.photohub.usecase.exception.BusinessException
import com.example.photohub.usecase.global.file.port.out.UploadFileToCloudPort
import com.example.photohub.usecase.group.port.out.persistence.FindMemberPort
import com.example.photohub.usecase.photocard.dto.request.CreatePhotoCardRequest
import com.example.photohub.usecase.photocard.model.PhotoCardModelFactory
import com.example.photohub.usecase.photocard.port.`in`.CreatePhotoCardUseCase
import com.example.photohub.usecase.photocard.port.out.persistence.SavePhotoCardPort

@UseCase
class CreatePhotoCardService(
    private val findMemberPort: FindMemberPort,
    private val uploadFileToCloudPort: UploadFileToCloudPort,
    private val photoCardModelFactory: PhotoCardModelFactory,
    private val savePhotoCardPort: SavePhotoCardPort
) : CreatePhotoCardUseCase {

    override fun invoke(req: CreatePhotoCardRequest) {

        val member = findMemberPort.findById(req.memberId)
            ?: throw BusinessException.MEMBER_NOT_FOUND

        val uploadedImageUrl = uploadFileToCloudPort(req.image)
        val uploadedBackImageUrl = uploadFileToCloudPort(req.backImage)

        val model = req.run {
            photoCardModelFactory.create(
                name = name,
                image = uploadedImageUrl,
                backImage = uploadedBackImageUrl,
                group = member.getGroup(),
                member = member,
            )
        }

        savePhotoCardPort.save(model)
    }
}