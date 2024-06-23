package com.example.photohub.infra.exception

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.web.filter.OncePerRequestFilter

class ExceptionResolverFilterChainProxy(
    private val filterChain: ExceptionResolverFilterChain
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        this.filterChain.doFilterOuter(request, response, filterChain)
    }
}