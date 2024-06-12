package com.example.photohub.usecase.photocard.dto.response

import com.example.photohub.usecase.photocard.model.PhotoCardModel
import java.util.*

data class PhotoCardInfoListResponse(
    val photoCards: List<PhotoCardInfo>
)

data class PhotoCardInfo(
    val id: UUID,
    val image: String
) {
    companion object {
        fun of(photoCardModel: PhotoCardModel): PhotoCardInfo = photoCardModel.run {
            PhotoCardInfo(
                id = getId(),
                image = getImage()
            )
        }
    }
}
