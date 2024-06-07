package com.example.photohub.usecase.exception

open class StatusCodeException protected constructor(
    val statusCode: Int,
    override val message: String
) : RuntimeException() {
    companion object {
        val NO_CONTENT
            get() = StatusCodeException(204, "No Content.")
    }
}

class BusinessException(
    statusCode: Int,
    message: String
) : StatusCodeException(statusCode, message) {
    companion object {
        val ENTITY_ID_NOT_ASSIGNED_BUT_CALL
            get() = BusinessException(500, "Entity's Id is not assigned BUT Called.")
    }
}

class AuthException(
    statusCode: Int,
    message: String
) : StatusCodeException(statusCode, message) {
    companion object {
        val INVALID_TOKEN
            get() = AuthException(401, "Invalid token.")
    }
}

class SecurityException(
    statusCode: Int,
    message: String
) : StatusCodeException(statusCode, message) {
    companion object {
        val ACCESS_DENIED_TO_RESOURCE
            get() = SecurityException(403, "Access Denied to Resource.")
    }
}