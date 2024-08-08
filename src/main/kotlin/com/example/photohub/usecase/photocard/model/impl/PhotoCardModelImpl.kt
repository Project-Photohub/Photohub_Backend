package com.example.photohub.usecase.photocard.model.impl

import com.example.photohub.data.photocard.entity.PhotoCardJpaEntity
import com.example.photohub.infra.file.S3BaseUrlJoiner
import com.example.photohub.usecase.exception.BusinessException
import com.example.photohub.usecase.global.model.MappingProvider
import com.example.photohub.usecase.group.model.GroupModel
import com.example.photohub.usecase.group.model.MemberModel
import com.example.photohub.usecase.group.model.impl.GroupModelImpl
import com.example.photohub.usecase.group.model.impl.MemberModelImpl
import com.example.photohub.usecase.photocard.model.PhotoCardModel
import com.example.photohub.usecase.user.model.UserModel
import com.example.photohub.usecase.user.model.impl.UserModelImpl
import java.time.LocalDateTime
import java.util.*

class PhotoCardModelImpl(
    val photoCardJpaEntity: PhotoCardJpaEntity,
    private val mappingProvider: MappingProvider
) : PhotoCardModel {

    override fun getId(): UUID = photoCardJpaEntity.id
        ?: throw BusinessException.ENTITY_ID_NOT_ASSIGNED_BUT_CALL

    override fun getName(): String = photoCardJpaEntity.name

    override fun getImageUrl(): String =
        S3BaseUrlJoiner.join(photoCardJpaEntity.imageId)

    override fun getBackImageUrl(): String =
        S3BaseUrlJoiner.join(photoCardJpaEntity.backImageId)

    override fun getLikeCount(): Long = photoCardJpaEntity.likeCount

    override fun getGroup(): GroupModel =
        GroupModelImpl(photoCardJpaEntity.group, mappingProvider)

    override fun getMember(): MemberModel =
        MemberModelImpl(photoCardJpaEntity.member, mappingProvider)

    override fun getUploader(): UserModel =
        UserModelImpl(photoCardJpaEntity.uploader, mappingProvider)

    override fun getCreatedAt(): LocalDateTime = photoCardJpaEntity.createdAt
}