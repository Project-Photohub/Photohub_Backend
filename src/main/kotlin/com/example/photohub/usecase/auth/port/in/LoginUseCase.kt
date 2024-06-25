package com.example.photohub.usecase.auth.port.`in`

import com.example.photohub.usecase.auth.dto.request.LoginRequest
import com.example.photohub.usecase.auth.dto.response.SessionIdResponse

interface LoginUseCase {

    operator fun invoke(req: LoginRequest): SessionIdResponse
}