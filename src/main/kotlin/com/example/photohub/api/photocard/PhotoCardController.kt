package com.example.photohub.api.photocard

import com.example.photohub.Controller
import com.example.photohub.usecase.photocard.dto.request.CreatePhotoCardWithImageUrlRequest
import com.example.photohub.usecase.photocard.dto.response.PhotoCardInfoListResponse
import com.example.photohub.usecase.photocard.dto.response.PhotoCardMaximumInfoResponse
import com.example.photohub.usecase.photocard.port.`in`.*
import org.jetbrains.annotations.NotNull
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RequestMapping("/photo-cards")
@Controller
class PhotoCardController(
    private val getPhotoCardFromIdUseCase: GetPhotoCardFromIdUseCase,
    private val getPhotoCardFromMemberUseCase: GetPhotoCardFromMemberUseCase,
    private val getPopularPhotoCardUseCase: GetPopularPhotoCardUseCase,
    private val getRandomPhotoCardUseCase: GetRandomPhotoCardUseCase,
    private val getLatestPhotoCardUseCase: GetLatestPhotoCardUseCase,
    private val createPhotoCardWithImageUrlUseCase: CreatePhotoCardWithImageUrlUseCase,
    private val likePhotoCardUseCase: LikePhotoCardUseCase
) {

    @GetMapping("/member/{memberId}")
    fun getPhotoCard(
        @NotNull
        @PathVariable("memberId")
        memberId: Long
    ): PhotoCardInfoListResponse =
        getPhotoCardFromMemberUseCase(memberId)

    @GetMapping("/{id}")
    fun getPhotoCardFromId(
        @NotNull
        @PathVariable("id")
        id: UUID
    ): PhotoCardMaximumInfoResponse =
        getPhotoCardFromIdUseCase(id)

    @GetMapping("/popular")
    fun getPopular(): PhotoCardInfoListResponse = getPopularPhotoCardUseCase()

    @GetMapping("/random")
    fun getRandom(): PhotoCardInfoListResponse = getRandomPhotoCardUseCase()

    @GetMapping("/latest")
    fun getLatest(): PhotoCardInfoListResponse = getLatestPhotoCardUseCase()

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