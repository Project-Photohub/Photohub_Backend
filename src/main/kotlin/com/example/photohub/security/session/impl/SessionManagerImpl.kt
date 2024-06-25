package com.example.photohub.security.session.impl

import com.example.photohub.security.session.SessionManager
import com.example.photohub.security.session.vo.Session
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.util.concurrent.atomic.AtomicInteger

@Component
class SessionManagerImpl : SessionManager {

    val sessions: MutableMap<String, Session> = HashMap()

    val sessionsSize: AtomicInteger = AtomicInteger(0)

    override fun getUsernameById(sessionId: String): String? {
        sessions[sessionId]?.let {
            if (it.isExpired()) {
                invalidateSession(sessionId)
                return null
            }
            return it.username
        }

        return null
    }

    override fun createSession(username: String): String {
        suspend { invalidateSessionsByUsername(username) }

        val session = Session(
            username = username,
            expireAt = LocalDateTime.now().plusHours(2)
        )

        sessions[session.sessionId] = session
        sessionsSize.incrementAndGet()

        return session.sessionId
    }

    private fun invalidateSession(sessionId: String) {
        sessions.remove(sessionId) ?: return

        sessionsSize.decrementAndGet()
    }

    private suspend fun invalidateSessionsByUsername(username: String) {
        sessions.values.forEach {
            if (it.username == username || it.isExpired()) {
                invalidateSession(it.sessionId)
            }
        }
    }

    private fun Session.isExpired(): Boolean =
        LocalDateTime.now().isAfter(this.expireAt)
}