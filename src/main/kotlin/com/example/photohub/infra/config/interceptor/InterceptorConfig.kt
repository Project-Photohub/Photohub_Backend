package com.example.photohub.infra.config.interceptor

import com.example.photohub.security.authentication.annotation.AnnotationBasedAuthenticateInterceptor
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class InterceptorConfig(
    private val annotationBasedAuthenticateInterceptor: AnnotationBasedAuthenticateInterceptor
) : WebMvcConfigurer {

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(
            annotationBasedAuthenticateInterceptor
        )
    }
}