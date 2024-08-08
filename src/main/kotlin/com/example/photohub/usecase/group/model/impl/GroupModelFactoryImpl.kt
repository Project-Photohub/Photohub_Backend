package com.example.photohub.usecase.group.model.impl

import com.example.photohub.ModelFactory
import com.example.photohub.data.group.entity.GroupJpaEntity
import com.example.photohub.usecase.global.model.MappingProvider
import com.example.photohub.usecase.group.model.GroupModel
import com.example.photohub.usecase.group.model.GroupModelFactory

@ModelFactory
class GroupModelFactoryImpl(
    private val mappingProvider: MappingProvider
) : GroupModelFactory {

    override fun create(name: String, logoId: String): GroupModel =
        GroupModelImpl(
            GroupJpaEntity(
                name = name,
                logoId = logoId
            ),
            mappingProvider
        )
}