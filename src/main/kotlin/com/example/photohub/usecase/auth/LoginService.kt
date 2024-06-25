package com.example.photohub.usecase.auth

import com.example.photohub.UseCase
import com.example.photohub.usecase.auth.dto.request.LoginRequest
import com.example.photohub.usecase.auth.dto.response.SessionIdResponse
import com.example.photohub.usecase.auth.port.`in`.LoginUseCase
import com.example.photohub.usecase.auth.port.out.CreateSessionPort
import com.example.photohub.usecase.auth.port.out.PasswordComparer
import com.example.photohub.usecase.exception.BusinessException
import com.example.photohub.usecase.exception.SecurityException
import com.example.photohub.usecase.user.port.out.persistence.FindUserPort

@UseCase
class LoginService(
    private val findUserPort: FindUserPort,
    private val createSessionPort: CreateSessionPort,
    private val passwordComparer: PasswordComparer,
) : LoginUseCase {

    override fun invoke(req: LoginRequest): SessionIdResponse {

        val user = findUserPort.findByUsername(req.id)
            ?: throw BusinessException.USER_NOT_FOUND

        if (!passwordComparer.isEqual(user.getPassword(), req.password)) {
            throw SecurityException.PASSWORD_MISMATCH
        }

        return createSessionPort(user.getUsername())
    }
}