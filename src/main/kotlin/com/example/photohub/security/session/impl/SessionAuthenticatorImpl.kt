package com.example.photohub.security.session.impl

import com.example.photohub.security.authentication.current.CurrentAuthenticationManager
import com.example.photohub.security.authentication.vo.UserLazyLoadingAuthentication
import com.example.photohub.security.session.SessionAuthenticator
import com.example.photohub.security.session.SessionManager
import com.example.photohub.usecase.exception.SecurityException
import jakarta.servlet.http.HttpServletRequest
import org.springframework.stereotype.Component

@Component
class SessionAuthenticatorImpl(
    private val sessionManager: SessionManager,
    private val currentAuthenticationManager: CurrentAuthenticationManager
) : SessionAuthenticator {

    companion object {
        const val SESSION_COOKIE_NAME = "SESSIONID"
    }

    override fun invoke(request: HttpServletRequest) {
        val sessionId = request.cookies?.firstOrNull { it.name == SESSION_COOKIE_NAME }?.value
            ?: return currentAuthenticationManager.initial(null)

        val username = sessionManager.getUsernameById(sessionId)
            ?: throw SecurityException.UNAUTHORIZED

        currentAuthenticationManager.initial(
            UserLazyLoadingAuthentication(username)
        )
    }
}