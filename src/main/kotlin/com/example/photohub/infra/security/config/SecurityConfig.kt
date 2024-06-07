package com.example.photohub.infra.security.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfig {

    @Bean
    fun configure(httpSecurity: HttpSecurity): SecurityFilterChain =
        httpSecurity
            .formLogin {
                it.disable()
            }

            .cors {
                it.disable()
            }

            .csrf {
                it.disable()
            }

            .authorizeHttpRequests {
                it.anyRequest().permitAll()
            }

            .build()
}