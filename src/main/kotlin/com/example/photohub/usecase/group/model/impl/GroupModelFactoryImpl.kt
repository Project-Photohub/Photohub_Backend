package com.example.photohub.usecase.group.model.impl

import com.example.photohub.ModelFactory
import com.example.photohub.data.group.entity.GroupJpaEntity
import com.example.photohub.data.group.repository.MemberRepository
import com.example.photohub.usecase.group.model.GroupModel
import com.example.photohub.usecase.group.model.GroupModelFactory

@ModelFactory
class GroupModelFactoryImpl(
    private val memberRepository: MemberRepository
) : GroupModelFactory {

    override fun create(id: Long?, name: String, logo: String): GroupModel =
        GroupModelImpl(
            GroupJpaEntity(
                name = name,
                logo = logo,
                id = id
            ),
            memberRepository
        )
}