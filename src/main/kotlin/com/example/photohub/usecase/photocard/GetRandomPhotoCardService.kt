package com.example.photohub.usecase.photocard

import com.example.photohub.ReadOnlyUseCase
import com.example.photohub.usecase.global.DsmPhotoCardRemover
import com.example.photohub.usecase.photocard.dto.response.PhotoCardInfo
import com.example.photohub.usecase.photocard.dto.response.PhotoCardInfoListResponse
import com.example.photohub.usecase.photocard.port.`in`.GetRandomPhotoCardUseCase
import com.example.photohub.usecase.photocard.port.out.persistence.FindPhotoCardPort

@ReadOnlyUseCase
class GetRandomPhotoCardService(
    private val findPhotoCardPort: FindPhotoCardPort
) : GetRandomPhotoCardUseCase {

    override fun invoke(): PhotoCardInfoListResponse =
        PhotoCardInfoListResponse(
            DsmPhotoCardRemover.removeDSMPhotoCard(
                findPhotoCardPort.findAllOrderRandomLimit30()
            ).map {
                PhotoCardInfo.of(it)
            }
        )
}