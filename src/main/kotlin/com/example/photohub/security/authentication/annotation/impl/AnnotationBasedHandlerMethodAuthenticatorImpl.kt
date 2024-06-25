package com.example.photohub.security.authentication.annotation.impl

import com.example.photohub.security.authentication.annotation.AnnotationBasedHandlerMethodAuthenticator
import com.example.photohub.security.authentication.annotation.RequireAuthenticated
import com.example.photohub.security.authentication.annotation.RequireRole
import com.example.photohub.security.authentication.current.CurrentAuthenticationManager
import com.example.photohub.usecase.exception.SecurityException
import org.springframework.stereotype.Component
import org.springframework.web.method.HandlerMethod

@Component
class AnnotationBasedHandlerMethodAuthenticatorImpl(
    private val currentAuthenticationManager: CurrentAuthenticationManager
) : AnnotationBasedHandlerMethodAuthenticator {

    override fun invoke(handlerMethod: HandlerMethod) {
        val annotation = handlerMethod.method.getAnnotation(RequireRole::class.java)
            ?: handlerMethod.method.getAnnotation(RequireAuthenticated::class.java)
            ?: return

        if (currentAuthenticationManager.getCurrent() == null) {
            throw SecurityException.UNAUTHORIZED
        }

        if (annotation !is RequireRole) {
            return
        }

        if (currentAuthenticationManager.getCurrent()!!.getUser().getRole() < annotation.role) {
            throw SecurityException.FORBIDDEN
        }
    }
}