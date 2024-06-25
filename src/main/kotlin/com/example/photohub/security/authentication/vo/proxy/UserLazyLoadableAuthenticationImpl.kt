package com.example.photohub.security.authentication.vo.proxy

import com.example.photohub.security.authentication.vo.UserLazyLoadableAuthentication
import com.example.photohub.usecase.exception.SecurityException
import com.example.photohub.usecase.user.model.UserModel
import com.example.photohub.usecase.user.port.out.persistence.FindUserPort

class UserLazyLoadableAuthenticationImpl(
    private val username: String,
    private val findUserPort: FindUserPort,
    private var user: UserModel? = null
) : UserLazyLoadableAuthentication {

    override fun getUsername(): String = username

    override fun getUser(): UserModel {
        if (user == null) {
            user = findUserPort.findByUsername(username)
                ?: throw SecurityException.INVALID_SESSION_ID
        }

        return user!!
    }
}