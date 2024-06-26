package com.example.photohub.api.photocard

import com.example.photohub.Controller
import com.example.photohub.security.authentication.annotation.RequireRole
import com.example.photohub.security.authentication.vo.Role
import com.example.photohub.usecase.photocard.dto.request.CreatePhotoCardRequest
import com.example.photohub.usecase.photocard.dto.request.CreatePhotoCardWithImageUrlRequest
import com.example.photohub.usecase.photocard.dto.response.PhotoCardInfoListResponse
import com.example.photohub.usecase.photocard.dto.response.PhotoCardMaximumInfoResponse
import com.example.photohub.usecase.photocard.port.`in`.*
import jakarta.validation.Valid
import jakarta.validation.constraints.Positive
import org.jetbrains.annotations.NotNull
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
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
    private val createPhotoCardUseCase: CreatePhotoCardUseCase,
    private val likePhotoCardUseCase: LikePhotoCardUseCase
) {

    @GetMapping("/member/{memberId}")
    fun getPhotoCard(
        @Valid
        @NotNull
        @Positive
        @PathVariable("memberId")
        memberId: Long
    ): PhotoCardInfoListResponse =
        getPhotoCardFromMemberUseCase(memberId)

    @GetMapping("/{id}")
    fun getPhotoCardFromId(
        @Valid
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

    // @ResponseStatus(HttpStatus.CREATED)
    // @PostMapping("/url")
    fun createPhotoCardFromUrl(
        @Validated
        @RequestBody
        req: CreatePhotoCardWithImageUrlRequest
    ) = createPhotoCardWithImageUrlUseCase(req)

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun createPhotoCard(
        @Valid
        @NotNull
        image: MultipartFile,
        @Valid
        @NotNull
        backImage: MultipartFile,
        @Valid
        @NotNull
        @RequestParam
        name: String,
        @Valid
        @NotNull
        @RequestParam
        memberId: Long,
    ) = createPhotoCardUseCase(
        CreatePhotoCardRequest(
            image, backImage, name, memberId
        )
    )

    @PatchMapping("/like/{photoCardId}")
    fun likePhotoCard(
        @Valid
        @NotNull
        @PathVariable("photoCardId")
        photoCardId: UUID
    ) = likePhotoCardUseCase(photoCardId)
}