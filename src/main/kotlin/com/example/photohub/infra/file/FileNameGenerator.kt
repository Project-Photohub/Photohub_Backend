package com.example.photohub.infra.file

import java.util.*

object FileNameGenerator {
    operator fun invoke(): String {
        return UUID.randomUUID().toString()
    }
}