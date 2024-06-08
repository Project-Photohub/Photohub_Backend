package com.example.photohub.usecase.photocard

import com.example.photohub.ReadOnlyUseCase
import com.example.photohub.usecase.exception.BusinessException
import com.example.photohub.usecase.exception.StatusCodeException
import com.example.photohub.usecase.group.port.out.persistence.FindMemberPort
import com.example.photohub.usecase.photocard.dto.response.PhotoCardInfo
import com.example.photohub.usecase.photocard.dto.response.PhotoCardInfoListResponse
import com.example.photohub.usecase.photocard.port.`in`.GetPhotoCardFromMemberUseCase

@ReadOnlyUseCase
class GetPhotoCardFromMemberService(
    private val findMemberPort: FindMemberPort
) : GetPhotoCardFromMemberUseCase {

    override fun invoke(memberId: Long): PhotoCardInfoListResponse {

        val member = findMemberPort.findById(memberId)
            ?: throw BusinessException.MEMBER_NOT_FOUND

        val photoCards = member.getPhotoCards()

        if (photoCards.isEmpty()) {
            throw StatusCodeException.NO_CONTENT
        }

        return PhotoCardInfoListResponse(
            photoCards.map {
                PhotoCardInfo.of(it)
            }
        )
    }
}