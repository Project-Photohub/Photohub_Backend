package com.example.photohub.usecase.photocard.model.impl

import com.example.photohub.data.photocard.entity.PhotoCardJpaEntity
import com.example.photohub.usecase.exception.BusinessException
import com.example.photohub.usecase.global.model.MappingProvider
import com.example.photohub.usecase.group.model.GroupModel
import com.example.photohub.usecase.group.model.MemberModel
import com.example.photohub.usecase.group.model.impl.GroupModelImpl
import com.example.photohub.usecase.group.model.impl.MemberModelImpl
import com.example.photohub.usecase.photocard.model.PhotoCardModel
import java.time.LocalDateTime
import java.util.*

class PhotoCardModelImpl(
    val photoCardJpaEntity: PhotoCardJpaEntity,
    private val mappingProvider: MappingProvider
) : PhotoCardModel {

    override fun getId(): UUID = photoCardJpaEntity.id
        ?: throw BusinessException.ENTITY_ID_NOT_ASSIGNED_BUT_CALL

    override fun getName(): String = photoCardJpaEntity.name

    override fun getImage(): String = photoCardJpaEntity.image

    override fun getBackImage(): String = photoCardJpaEntity.backImage

    override fun getLikeCount(): Long = photoCardJpaEntity.likeCount

    override fun getGroup(): GroupModel =
        GroupModelImpl(photoCardJpaEntity.member.group, mappingProvider)

    override fun getMember(): MemberModel =
        MemberModelImpl(photoCardJpaEntity.member, mappingProvider)

    override fun getCreatedAt(): LocalDateTime = photoCardJpaEntity.createdAt
}