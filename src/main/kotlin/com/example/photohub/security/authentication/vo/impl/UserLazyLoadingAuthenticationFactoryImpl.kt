package com.example.photohub.security.authentication.vo.impl

import com.example.photohub.security.authentication.vo.UserLazyLoadableAuthentication
import com.example.photohub.security.authentication.vo.UserLazyLoadingAuthenticationFactory
import com.example.photohub.security.authentication.vo.proxy.UserLazyLoadableAuthenticationImpl
import com.example.photohub.usecase.user.port.out.persistence.FindUserPort
import org.springframework.stereotype.Component

@Component
class UserLazyLoadingAuthenticationFactoryImpl(
    private val findUserPort: FindUserPort
) : UserLazyLoadingAuthenticationFactory {

    override fun create(username: String): UserLazyLoadableAuthentication =
        UserLazyLoadableAuthenticationImpl(
            username, findUserPort
        )
}