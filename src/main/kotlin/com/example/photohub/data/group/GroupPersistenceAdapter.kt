package com.example.photohub.data.group

import com.example.photohub.PersistenceAdapter
import com.example.photohub.data.group.repository.GroupRepository
import com.example.photohub.usecase.global.model.MappingProvider
import com.example.photohub.usecase.group.model.GroupModel
import com.example.photohub.usecase.group.model.impl.GroupModelImpl
import com.example.photohub.usecase.group.port.out.persistence.FindGroupPort
import com.example.photohub.usecase.group.port.out.persistence.SaveGroupPort

@PersistenceAdapter
class GroupPersistenceAdapter(
    private val groupRepository: GroupRepository,
    private val mappingProvider: MappingProvider
) : SaveGroupPort,
    FindGroupPort {

    override fun save(group: GroupModel): GroupModel =
        GroupModelImpl(
            groupRepository.save((group as GroupModelImpl).groupJpaEntity),
            mappingProvider
        )

    override fun findById(id: Long): GroupModel? =
        groupRepository.findById(id)?.run {
            GroupModelImpl(this, mappingProvider)
        }

    override fun findAllGroup(): List<GroupModel> =
        groupRepository.findAll().map {
            GroupModelImpl(it, mappingProvider)
        }
}