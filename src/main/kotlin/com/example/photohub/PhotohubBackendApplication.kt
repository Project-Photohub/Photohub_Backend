package com.example.photohub

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity

@EnableWebSecurity
@SpringBootApplication
class PhotohubBackendApplication

fun main(args: Array<String>) {
    runApplication<PhotohubBackendApplication>(*args)
}
