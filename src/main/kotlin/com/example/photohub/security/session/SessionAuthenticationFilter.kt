package com.example.photohub.security.session

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.web.filter.OncePerRequestFilter

class SessionAuthenticationFilter(
    private val sessionAuthenticator: SessionAuthenticator
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        sessionAuthenticator(request)

        filterChain.doFilter(request, response)
    }
}