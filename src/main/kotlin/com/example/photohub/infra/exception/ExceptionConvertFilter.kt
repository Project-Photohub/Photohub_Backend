package com.example.photohub.infra.exception

import com.example.photohub.usecase.exception.StatusCodeException
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletException
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.web.filter.OncePerRequestFilter

class ExceptionConvertFilter : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch (e: ServletException) {

            when (e.rootCause) {
                is StatusCodeException -> {
                    throw e.rootCause
                }
            }
        }
    }
}