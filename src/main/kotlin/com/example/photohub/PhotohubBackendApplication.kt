package com.example.photohub

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PhotohubBackendApplication

fun main(args: Array<String>) {
    runApplication<PhotohubBackendApplication>(*args)
}
