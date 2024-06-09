package com.example.photohub.usecase.photocard.dto.response

import com.example.photohub.usecase.photocard.model.PhotoCardModel
import java.time.LocalDate
import java.util.*

data class PhotoCardInfoListResponse(
    val photoCards: List<PhotoCardInfo>
)

data class PhotoCardInfo(
    val id: UUID,
    val name: String,
    val image: String,
    val backImage: String,
    val groupName: String,
    val memberName: String,
    val memberNickname: String,
    val createdAt: LocalDate,
    val likeCount: Long
) {
    companion object {
        fun of(photoCardModel: PhotoCardModel): PhotoCardInfo = photoCardModel.run {
            PhotoCardInfo(
                id = getId(),
                name = getName(),
                image = getImage(),
                backImage = getBackImage(),
                groupName = getGroup().getName(),
                memberName = getMember().getName(),
                memberNickname = getMember().getNickname(),
                createdAt = getCreatedAt(),
                likeCount = getLikeCount()
            )
        }
    }
}
