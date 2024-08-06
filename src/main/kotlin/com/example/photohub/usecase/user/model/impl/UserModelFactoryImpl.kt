package com.example.photohub.usecase.user.model.impl

import com.example.photohub.ModelFactory
import com.example.photohub.data.user.entity.UserJpaEntity
import com.example.photohub.security.authentication.vo.Role
import com.example.photohub.usecase.global.model.MappingProvider
import com.example.photohub.usecase.user.model.UserModel
import com.example.photohub.usecase.user.model.UserModelFactory

@ModelFactory
class UserModelFactoryImpl(
    private val mappingProvider: MappingProvider
) : UserModelFactory {

    override fun create(
        name: String,
        username: String,
        password: String,
        role: Role
    ): UserModel =
        UserModelImpl(
            UserJpaEntity(
                name, username, password, role
            ),
            mappingProvider
        )
}