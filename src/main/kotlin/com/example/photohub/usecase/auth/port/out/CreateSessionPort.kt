package com.example.photohub.usecase.auth.port.out

import com.example.photohub.usecase.auth.dto.response.SessionIdResponse

interface CreateSessionPort {

    operator fun invoke(username: String): SessionIdResponse
}