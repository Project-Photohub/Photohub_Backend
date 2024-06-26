package com.example.photohub.usecase.photocard

import com.example.photohub.ReadOnlyUseCase
import com.example.photohub.usecase.global.DsmPhotoCardRemover
import com.example.photohub.usecase.global.OrderScatter
import com.example.photohub.usecase.photocard.dto.response.PhotoCardInfo
import com.example.photohub.usecase.photocard.dto.response.PhotoCardInfoListResponse
import com.example.photohub.usecase.photocard.port.`in`.GetLatestPhotoCardUseCase
import com.example.photohub.usecase.photocard.port.out.persistence.FindPhotoCardPort

@ReadOnlyUseCase
class GetLatestPhotoCardService(
    private val findPhotoCardPort: FindPhotoCardPort
) : GetLatestPhotoCardUseCase {

    override fun invoke(): PhotoCardInfoListResponse {
        val photoCards = DsmPhotoCardRemover.removeDSMPhotoCard(
            findPhotoCardPort.findAllOrderCreateAtLimit30()
        ).map {
            PhotoCardInfo.of(it)
        }

        return PhotoCardInfoListResponse(
            OrderScatter(photoCards)
        )
    }
}