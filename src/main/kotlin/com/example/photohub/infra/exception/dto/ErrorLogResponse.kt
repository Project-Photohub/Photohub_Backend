package com.example.photohub.infra.exception.dto

import java.time.LocalDateTime
import java.util.*

data class ErrorLogResponse(
    val statusCode: Int,
    val message: String,
    val errorId: String,
    val timestamp: LocalDateTime
) {
    companion object {
        val INTERNAL_SERVER_ERROR: ErrorLogResponse
            get() = ErrorLogResponse(
                500,
                "Internal Server Error",
                UUID.randomUUID().toString().substring(0, 7),
                LocalDateTime.now()
            )
    }
}
