package com.example.photohub.data.group

import com.example.photohub.PersistenceAdapter
import com.example.photohub.data.group.repository.GroupRepository
import com.example.photohub.usecase.group.model.GroupModel
import com.example.photohub.usecase.group.model.impl.GroupModelImpl
import com.example.photohub.usecase.group.port.out.persistence.FindGroupPort

@PersistenceAdapter
class GroupPersistenceAdapter(
    private val groupRepository: GroupRepository
) : FindGroupPort {

    override fun findById(id: Long): GroupModel? =
        groupRepository.findById(id)?.run {
            GroupModelImpl(this)
        }

    override fun findAllGroup(): List<GroupModel> =
        groupRepository.findAll().map {
            GroupModelImpl(it)
        }
}