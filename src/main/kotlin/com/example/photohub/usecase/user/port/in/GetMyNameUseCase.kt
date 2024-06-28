package com.example.photohub.usecase.user.port.`in`

import com.example.photohub.usecase.user.dto.response.MyNameResponse

interface GetMyNameUseCase {

    operator fun invoke(): MyNameResponse
}