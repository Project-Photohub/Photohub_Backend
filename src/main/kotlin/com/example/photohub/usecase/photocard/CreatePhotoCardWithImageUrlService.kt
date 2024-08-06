package com.example.photohub.usecase.photocard

import com.example.photohub.UseCase
import com.example.photohub.usecase.exception.BusinessException
import com.example.photohub.usecase.group.port.out.persistence.FindMemberPort
import com.example.photohub.usecase.photocard.dto.request.CreatePhotoCardWithImageUrlRequest
import com.example.photohub.usecase.photocard.model.PhotoCardModelFactory
import com.example.photohub.usecase.photocard.port.`in`.CreatePhotoCardWithImageUrlUseCase
import com.example.photohub.usecase.photocard.port.out.persistence.SavePhotoCardPort
import com.example.photohub.usecase.user.port.out.GetCurrentUserPort

@UseCase
class CreatePhotoCardWithImageUrlService(
    private val findMemberPort: FindMemberPort,
    private val savePhotoCardPort: SavePhotoCardPort,
    private val photoCardModelFactory: PhotoCardModelFactory,
    private val getCurrentUserPort: GetCurrentUserPort
) : CreatePhotoCardWithImageUrlUseCase {

    override fun invoke(request: CreatePhotoCardWithImageUrlRequest) {

        val member = findMemberPort.findById(request.memberId)
            ?: throw BusinessException.MEMBER_NOT_FOUND

        val model = request.run {
            photoCardModelFactory.create(
                name = name,
                image = image,
                backImage = backImage,
                member = member,
                uploader = getCurrentUserPort()
            )
        }

        savePhotoCardPort.save(model)
    }
}