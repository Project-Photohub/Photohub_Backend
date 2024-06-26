package com.example.photohub.usecase.group.model.impl

import com.example.photohub.ModelFactory
import com.example.photohub.data.group.entity.MemberJpaEntity
import com.example.photohub.usecase.global.model.MappingProvider
import com.example.photohub.usecase.group.model.GroupModel
import com.example.photohub.usecase.group.model.MemberModel
import com.example.photohub.usecase.group.model.MemberModelFactory

@ModelFactory
class MemberModelFactoryImpl(
    private val mappingProvider: MappingProvider
) : MemberModelFactory {

    override fun create(
        name: String,
        nickname: String?,
        groupModel: GroupModel
    ): MemberModel =
        MemberModelImpl(
            MemberJpaEntity(
                name = name,
                nickname = nickname,
                group = (groupModel as GroupModelImpl).groupJpaEntity
            ),
            mappingProvider
        )
}