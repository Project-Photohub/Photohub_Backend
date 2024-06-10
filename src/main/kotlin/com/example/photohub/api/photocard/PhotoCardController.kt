package com.example.photohub.api.photocard

import com.example.photohub.Controller
import com.example.photohub.usecase.photocard.dto.request.CreatePhotoCardWithImageUrlRequest
import com.example.photohub.usecase.photocard.dto.response.PhotoCardInfoListResponse
import com.example.photohub.usecase.photocard.port.`in`.CreatePhotoCardWithImageUrlUseCase
import com.example.photohub.usecase.photocard.port.`in`.GetPhotoCardFromMemberUseCase
import com.example.photohub.usecase.photocard.port.`in`.LikePhotoCardUseCase
import org.jetbrains.annotations.NotNull
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RequestMapping("/photo-cards")
@Controller
class PhotoCardController(
    private val getPhotoCardFromMemberUseCase: GetPhotoCardFromMemberUseCase,
    private val createPhotoCardWithImageUrlUseCase: CreatePhotoCardWithImageUrlUseCase,
    private val likePhotoCardUseCase: LikePhotoCardUseCase
) {

    @GetMapping("/member/{memberId}")
    fun getPhotoCard(
        @PathVariable("memberId")
        memberId: Long
    ): PhotoCardInfoListResponse =
        getPhotoCardFromMemberUseCase(memberId)

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/url")
    fun createPhotoCardFromUrl(
        @RequestBody
        req: CreatePhotoCardWithImageUrlRequest
    ) = createPhotoCardWithImageUrlUseCase(req)

    @PatchMapping("/like/{photoCardId}")
    fun likePhotoCard(
        @NotNull
        @PathVariable("photoCardId")
        photoCardId: UUID
    ) = likePhotoCardUseCase(photoCardId)
}