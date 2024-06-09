package com.example.photohub.infra.security.config

import jakarta.servlet.http.HttpServletRequest
import org.springframework.context.annotation.Configuration
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource

@Configuration
class CorsConfig : CorsConfigurationSource {

    override fun getCorsConfiguration(request: HttpServletRequest): CorsConfiguration =
        CorsConfiguration().apply {

            allowedOrigins = listOf("http://localhost:3000")
            setAllowedMethods(listOf("*"))
            allowCredentials = true
            allowedHeaders = listOf("*")
            maxAge = 3600L
        }
}