package com.example.photohub.data.group

import com.example.photohub.PersistenceAdapter
import com.example.photohub.data.group.repository.GroupRepository
import com.example.photohub.usecase.group.model.GroupModel
import com.example.photohub.usecase.group.model.impl.GroupModelImpl
import com.example.photohub.usecase.group.port.out.persistence.GetGroupPort

@PersistenceAdapter
class GroupPersistenceAdapter(
    private val groupRepository: GroupRepository
) : GetGroupPort {

    override fun getAllGroup(): List<GroupModel> =
        groupRepository.getAll().map {
            GroupModelImpl(it)
        }
}