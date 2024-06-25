package com.example.photohub.security.session

import com.example.photohub.usecase.auth.dto.response.SessionIdResponse
import com.example.photohub.usecase.auth.port.out.CreateSessionPort
import org.springframework.stereotype.Component

@Component
class SessionGenerator(
    private val sessionManager: SessionManager
) : CreateSessionPort {

    override fun invoke(username: String): SessionIdResponse =
        SessionIdResponse(
            sessionManager.createSession(username)
        )
}