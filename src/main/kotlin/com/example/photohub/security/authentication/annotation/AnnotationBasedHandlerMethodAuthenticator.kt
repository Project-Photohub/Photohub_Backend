package com.example.photohub.security.authentication.annotation

import org.springframework.web.method.HandlerMethod

interface AnnotationBasedHandlerMethodAuthenticator {

    operator fun invoke(handlerMethod: HandlerMethod)
}