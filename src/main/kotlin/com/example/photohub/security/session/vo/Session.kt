package com.example.photohub.security.session.vo

import java.time.LocalDateTime
import java.util.*

class Session(
    val sessionId: String = UUID.randomUUID().toString(),
    val username: String,
    val expireAt: LocalDateTime
)