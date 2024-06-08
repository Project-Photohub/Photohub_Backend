package com.example.photohub.usecase.user.model.impl

import com.example.photohub.data.user.entity.UserJpaEntity
import com.example.photohub.usecase.user.model.UserModel

class UserModelImpl(
    val userJpaEntity: UserJpaEntity
) : UserModel {

    override fun getName(): String = userJpaEntity.name

    override fun getUsername(): String = userJpaEntity.username

    override fun getPassword(): String = userJpaEntity.password
}