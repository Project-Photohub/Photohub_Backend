package com.example.photohub.usecase.group.model.impl

import com.example.photohub.data.group.entity.MemberJpaEntity
import com.example.photohub.usecase.exception.BusinessException
import com.example.photohub.usecase.global.model.RepositoryProvider
import com.example.photohub.usecase.group.model.GroupModel
import com.example.photohub.usecase.group.model.MemberModel
import com.example.photohub.usecase.photocard.model.PhotoCardModel
import com.example.photohub.usecase.photocard.model.impl.PhotoCardModelImpl

class MemberModelImpl(
    val memberJpaEntity: MemberJpaEntity,
    private val repositoryProvider: RepositoryProvider
) : MemberModel {

    override fun getId(): Long = memberJpaEntity.id
        ?: throw BusinessException.ENTITY_ID_NOT_ASSIGNED_BUT_CALL

    override fun getName(): String = memberJpaEntity.name

    override fun getNickname(): String? = memberJpaEntity.nickname

    override fun getGroup(): GroupModel =
        GroupModelImpl(memberJpaEntity.group, repositoryProvider)

    override fun getPhotoCards(): List<PhotoCardModel> =
        repositoryProvider.getPhotoCardRepository().findAllByMember(getId()).map {
            PhotoCardModelImpl(it, repositoryProvider)
        }
}