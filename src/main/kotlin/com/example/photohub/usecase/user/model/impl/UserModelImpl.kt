package com.example.photohub.usecase.user.model.impl

import com.example.photohub.data.user.entity.UserJpaEntity
import com.example.photohub.usecase.user.model.UserModel

@Deprecated(message = "유저 관련 기능이 제거됨")
class UserModelImpl(
    val userJpaEntity: UserJpaEntity
) : UserModel {

    override fun getName(): String = userJpaEntity.name

    override fun getUsername(): String = userJpaEntity.username

    override fun getPassword(): String = userJpaEntity.password
}