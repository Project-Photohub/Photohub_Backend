package com.example.photohub

import com.example.photohub.infra.env.file.S3Properties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity

@ConfigurationPropertiesScan("com.example.photohub.infra.env.**")
@EnableConfigurationProperties(S3Properties::class)
@EnableWebSecurity
@SpringBootApplication
class PhotohubBackendApplication

fun main(args: Array<String>) {
    runApplication<PhotohubBackendApplication>(*args)
}
