package com.example.photohub.security.authentication.current

import com.example.photohub.infra.threadlocal.ThreadLocalRemovable
import com.example.photohub.security.authentication.vo.UserLazyLoadableAuthentication
import com.example.photohub.usecase.exception.StatusCodeException
import org.springframework.stereotype.Component

@Component
class CurrentAuthenticationManagerImpl : CurrentAuthenticationManager, ThreadLocalRemovable {

    val authentication: ThreadLocal<UserLazyLoadableAuthentication?> = ThreadLocal.withInitial { null }

    val initialed: ThreadLocal<Boolean> = ThreadLocal.withInitial { false }

    override fun initial(authentication: UserLazyLoadableAuthentication?) {
        if (isInitialed()) {
            throw StatusCodeException(500, "CurrentAuthenticationManager already initialized")
        }

        this.authentication.set(authentication)

        this.initialed.set(true)
    }

    override fun isInitialed(): Boolean =
        this.initialed.get()

    override fun getCurrent(): UserLazyLoadableAuthentication? {
        if (!isInitialed()) {
            throw IllegalStateException("CurrentAuthenticationManager is not initialized")
        }

        return this.authentication.get()
    }

    override fun removeAll() {
        this.authentication.remove()
        this.initialed.remove()
    }
}