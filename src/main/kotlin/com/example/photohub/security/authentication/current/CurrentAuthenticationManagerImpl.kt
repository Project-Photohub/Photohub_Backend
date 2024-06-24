package com.example.photohub.security.authentication.current

import com.example.photohub.usecase.exception.StatusCodeException
import org.springframework.security.authentication.AnonymousAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class CurrentAuthenticationManagerImpl : CurrentAuthenticationManager {

    val initialed: ThreadLocal<Boolean> = ThreadLocal.withInitial { false }

    override fun initial(authentication: Authentication?) {
        if (isInitialed()) {
            throw StatusCodeException(500, "CurrentAuthenticationManager already initialized")
        }

        SecurityContextHolder.getContext().authentication = authentication

        initialed.set(true)
    }

    override fun isInitialed(): Boolean {
        if (SecurityContextHolder.getContext().authentication != null) {
            initialed.set(true)
        }

        return initialed.get()
    }

    override fun getCurrentOrNullIfAnonymous(): Authentication? {
        val auth = SecurityContextHolder.getContext().authentication

        if (auth is AnonymousAuthenticationToken) {
            return null
        }

        return auth
    }

    override fun getCurrent(): Authentication? =
        SecurityContextHolder.getContext().authentication
}