package com.example.photohub.security.config

import com.example.photohub.security.session.SessionAuthenticationFilter
import com.example.photohub.security.session.SessionAuthenticator
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.logout.LogoutFilter

@Configuration
class SecurityConfig(
    private val corsConfig: CorsConfig,
    private val sessionAuthenticator: SessionAuthenticator
) {

    @Bean
    fun configure(httpSecurity: HttpSecurity): SecurityFilterChain =
        httpSecurity
            .formLogin {
                it.disable()
            }

            .cors {
                it.configurationSource(corsConfig)
            }

            .csrf {
                it.disable()
            }

            .authorizeHttpRequests {
                it.anyRequest().permitAll()
            }

            .addFilterBefore(
                SessionAuthenticationFilter(sessionAuthenticator),
                LogoutFilter::class.java
            )

            .build()
}