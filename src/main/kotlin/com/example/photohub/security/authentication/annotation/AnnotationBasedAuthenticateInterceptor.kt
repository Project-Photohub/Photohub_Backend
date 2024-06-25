package com.example.photohub.security.authentication.annotation

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Component
import org.springframework.web.method.HandlerMethod
import org.springframework.web.servlet.HandlerInterceptor

@Component
class AnnotationBasedAuthenticateInterceptor(
    private val annotationBasedHandlerMethodAuthenticator: AnnotationBasedHandlerMethodAuthenticator
) : HandlerInterceptor {

    override fun preHandle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any
    ): Boolean {

        if (handler is HandlerMethod) {
            annotationBasedHandlerMethodAuthenticator(handler)
        }

        return true
    }
}