package com.example.photohub.usecase.user.model.impl

import com.example.photohub.ModelFactory
import com.example.photohub.data.user.entity.UserJpaEntity
import com.example.photohub.usecase.user.model.UserModel
import com.example.photohub.usecase.user.model.UserModelFactory

@ModelFactory
class UserModelFactoryImpl : UserModelFactory {

    override fun create(
        name: String,
        username: String,
        password: String
    ): UserModel =
        UserModelImpl(
            UserJpaEntity(
                name, username, password
            )
        )
}