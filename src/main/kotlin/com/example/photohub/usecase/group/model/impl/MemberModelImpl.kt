package com.example.photohub.usecase.group.model.impl

import com.example.photohub.data.group.entity.MemberJpaEntity
import com.example.photohub.usecase.exception.BusinessException
import com.example.photohub.usecase.global.model.MappingProvider
import com.example.photohub.usecase.group.model.GroupModel
import com.example.photohub.usecase.group.model.MemberModel
import com.example.photohub.usecase.photocard.model.PhotoCardModel

class MemberModelImpl(
    val memberJpaEntity: MemberJpaEntity,
    private val mappingProvider: MappingProvider
) : MemberModel {

    override fun getId(): Long = memberJpaEntity.id
        ?: throw BusinessException.ENTITY_ID_NOT_ASSIGNED_BUT_CALL

    override fun getName(): String = memberJpaEntity.name

    override fun getNickname(): String? = memberJpaEntity.nickname

    override fun getGroup(): GroupModel =
        GroupModelImpl(memberJpaEntity.group, mappingProvider)

    override fun getPhotoCards(): List<PhotoCardModel> =
        mappingProvider.getPhotoCardsByMember(this.getId())
}