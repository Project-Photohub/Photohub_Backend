package com.example.photohub.security.session.impl

import com.example.photohub.security.authentication.current.CurrentAuthenticationManager
import com.example.photohub.security.authentication.vo.UserLazyLoadingAuthenticationFactory
import com.example.photohub.security.session.SessionAuthenticator
import com.example.photohub.security.session.SessionManager
import com.example.photohub.security.session.env.SessionEnv
import jakarta.servlet.http.HttpServletRequest
import org.springframework.stereotype.Component

@Component
class SessionAuthenticatorImpl(
    private val sessionManager: SessionManager,
    private val currentAuthenticationManager: CurrentAuthenticationManager,
    private val userLazyLoadingAuthenticationFactory: UserLazyLoadingAuthenticationFactory
) : SessionAuthenticator {

    override fun invoke(request: HttpServletRequest) {
        val sessionId = request.cookies?.firstOrNull { it.name == SessionEnv.SESSION_COOKIE_NAME }?.value
            ?: return currentAuthenticationManager.initial(null)

        val username = sessionManager.getUsernameById(sessionId)
            ?: return currentAuthenticationManager.initial(null)

        currentAuthenticationManager.initial(
            userLazyLoadingAuthenticationFactory.create(username)
        )
    }
}