package com.example.photohub.infra.user

import com.example.photohub.security.authentication.current.CurrentAuthenticationManager
import com.example.photohub.usecase.exception.SecurityException
import com.example.photohub.usecase.user.model.UserModel
import com.example.photohub.usecase.user.port.out.GetCurrentUserPort
import org.springframework.stereotype.Component

@Component
class GetCurrentUserAdapter(
    private val currentAuthenticationManager: CurrentAuthenticationManager
) : GetCurrentUserPort {

    override fun invoke(): UserModel =
        currentAuthenticationManager.getCurrent()?.getUser()
            ?: throw SecurityException.UNAUTHORIZED
}