package com.example.photohub.usecase.auth.port.`in`

import com.example.photohub.usecase.auth.dto.request.SignupRequest

interface SignupUseCase {

    operator fun invoke(req: SignupRequest)
}