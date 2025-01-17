package com.example.photohub.usecase.user.model.impl

import com.example.photohub.data.user.entity.UserJpaEntity
import com.example.photohub.security.authentication.vo.Role
import com.example.photohub.usecase.global.model.MappingProvider
import com.example.photohub.usecase.photocard.model.PhotoCardModel
import com.example.photohub.usecase.user.model.UserModel

class UserModelImpl(
    val userJpaEntity: UserJpaEntity,
    private val mappingProvider: MappingProvider
) : UserModel {

    override fun getName(): String = userJpaEntity.name

    override fun getUsername(): String = userJpaEntity.username

    override fun getPassword(): String = userJpaEntity.password

    override fun getRole(): Role = userJpaEntity.role

    override fun getUploadedPhotoCards(): List<PhotoCardModel> =
        mappingProvider.getPhotoCardsByUploaderId(this.userJpaEntity.id!!)
}