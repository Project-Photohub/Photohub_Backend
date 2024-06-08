package com.example.photohub.usecase.photocard.port.`in`

import com.example.photohub.usecase.photocard.dto.response.PhotoCardInfoListResponse

interface GetPhotoCardFromMemberUseCase {

    operator fun invoke(memberId: Long): PhotoCardInfoListResponse
}