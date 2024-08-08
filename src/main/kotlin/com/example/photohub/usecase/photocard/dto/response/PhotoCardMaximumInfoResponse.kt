package com.example.photohub.usecase.photocard.dto.response

import com.example.photohub.usecase.photocard.model.PhotoCardModel
import java.time.LocalDate
import java.util.*

data class PhotoCardMaximumInfoResponse(
    val id: UUID,
    val name: String,
    val image: String,
    val backImage: String,
    val groupName: String,
    val memberName: String,
    val memberNickname: String?,
    val createdAt: LocalDate,
    val likeCount: Long
) {
    companion object {
        fun of(photoCardModel: PhotoCardModel): PhotoCardMaximumInfoResponse =
            photoCardModel.run {
                PhotoCardMaximumInfoResponse(
                    id = getId(),
                    name = getName(),
                    image = getImageUrl(),
                    backImage = getBackImageUrl(),
                    groupName = getGroup().getName(),
                    memberName = getMember().getName(),
                    memberNickname = getMember().getNickname(),
                    createdAt = getCreatedAt().toLocalDate(),
                    likeCount = getLikeCount()
                )
            }
    }
}
