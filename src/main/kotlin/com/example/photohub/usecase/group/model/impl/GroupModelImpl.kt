package com.example.photohub.usecase.group.model.impl

import com.example.photohub.data.group.entity.GroupJpaEntity
import com.example.photohub.usecase.exception.BusinessException
import com.example.photohub.usecase.global.model.RepositoryProvider
import com.example.photohub.usecase.group.model.GroupModel

class GroupModelImpl(
    val groupJpaEntity: GroupJpaEntity,
    private val repositoryProvider: RepositoryProvider
) : GroupModel {

    override fun getId() = groupJpaEntity.id
        ?: throw BusinessException.ENTITY_ID_NOT_ASSIGNED_BUT_CALL

    override fun getName() = groupJpaEntity.name

    override fun getLogo() = groupJpaEntity.logo

    override fun getMembers() =
        repositoryProvider.getMemberRepository().findAllByGroup(getId()).map {
            MemberModelImpl(it, repositoryProvider)
        }
}
