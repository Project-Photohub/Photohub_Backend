package com.example.photohub.api.photocard

import com.example.photohub.Controller
import com.example.photohub.usecase.photocard.dto.response.PhotoCardInfoListResponse
import com.example.photohub.usecase.photocard.port.`in`.GetPhotoCardFromMemberUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/photo-cards")
@Controller
class PhotoCardController(
    private val getPhotoCardFromMemberUseCase: GetPhotoCardFromMemberUseCase
) {

    @GetMapping("/member/{memberId}")
    fun getPhotoCard(
        @PathVariable("memberId")
        memberId: Long
    ): PhotoCardInfoListResponse =
        getPhotoCardFromMemberUseCase(memberId)
}