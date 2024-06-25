package com.example.photohub.usecase.auth

import com.example.photohub.UseCase
import com.example.photohub.usecase.auth.dto.request.SignupRequest
import com.example.photohub.usecase.auth.port.`in`.SignupUseCase
import com.example.photohub.usecase.auth.port.out.PasswordEncoder
import com.example.photohub.usecase.exception.BusinessException
import com.example.photohub.usecase.user.model.UserModelFactory
import com.example.photohub.usecase.user.port.out.persistence.ExistUserPort
import com.example.photohub.usecase.user.port.out.persistence.SaveUserPort

@UseCase
class SignupService(
    private val existUserPort: ExistUserPort,
    private val saveUserPort: SaveUserPort,
    private val userModelFactory: UserModelFactory,
    private val passwordEncoder: PasswordEncoder
) : SignupUseCase {

    override fun invoke(req: SignupRequest) {

        if (existUserPort.existByUserName(req.id)) {
            throw BusinessException(409, "Username already exists")
        }

        saveUserPort.save(
            userModelFactory.create(
                name = req.nickname,
                username = req.id,
                password = passwordEncoder(req.password)
            )
        )
    }
}