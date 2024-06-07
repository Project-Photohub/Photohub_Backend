package com.example.photohub.usecase.exception

open class StatusCodeException(
    val statusCode: Int,
    override val message: String
) : RuntimeException() {
    companion object {
        val INTERNAL_SERVER_ERROR
            get() = StatusCodeException(500, "Internal Server Error")
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

        val GROUP_NOT_FOUND
            get() = BusinessException(400, "Group Not Found.")
        val MEMBER_NOT_FOUND
            get() = BusinessException(400, "Member Not Found.")
        val PHOTO_CARD_NOT_FOUND
            get() = BusinessException(400, "Photo Card Not Found.")
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