package com.example.photohub.usecase.photocard

import com.example.photohub.ReadOnlyUseCase
import com.example.photohub.usecase.global.OrderScatter
import com.example.photohub.usecase.photocard.dto.response.PhotoCardInfo
import com.example.photohub.usecase.photocard.dto.response.PhotoCardInfoListResponse
import com.example.photohub.usecase.photocard.port.`in`.GetPopularPhotoCardUseCase
import com.example.photohub.usecase.photocard.port.out.persistence.FindPhotoCardPort

@ReadOnlyUseCase
class GetPopularPhotoCardService(
    private val findPhotoCardPort: FindPhotoCardPort
) : GetPopularPhotoCardUseCase {

    override fun invoke(): PhotoCardInfoListResponse {

        val photoCards = findPhotoCardPort.findAllOrderLikeCountLimit30().map {
            PhotoCardInfo.of(it)
        }

        return PhotoCardInfoListResponse(
            OrderScatter(photoCards)
        )
    }
}