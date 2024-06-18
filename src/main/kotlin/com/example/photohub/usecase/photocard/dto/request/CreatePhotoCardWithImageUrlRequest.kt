package com.example.photohub.usecase.photocard.dto.request

import jakarta.validation.Valid
import jakarta.validation.constraints.Positive
import jakarta.validation.constraints.Size
import org.jetbrains.annotations.NotNull
import org.springframework.validation.annotation.Validated

@Validated
data class CreatePhotoCardWithImageUrlRequest(

    @field:Valid
    @field:NotNull
    @field:Size(min = 1, max = 50)
    val name: String,

    @field:Valid
    @field:NotNull
    val image: String,

    @field:Valid
    @field:NotNull
    val backImage: String,

    @field:Valid
    @field:NotNull
    @field:Positive
    val memberId: Long,
)
