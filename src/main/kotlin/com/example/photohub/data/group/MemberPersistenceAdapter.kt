package com.example.photohub.data.group

import com.example.photohub.PersistenceAdapter
import com.example.photohub.data.group.repository.MemberRepository
import com.example.photohub.usecase.global.model.MappingProvider
import com.example.photohub.usecase.group.model.MemberModel
import com.example.photohub.usecase.group.model.impl.MemberModelImpl
import com.example.photohub.usecase.group.port.out.persistence.FindMemberPort
import com.example.photohub.usecase.group.port.out.persistence.SaveMemberPort

@PersistenceAdapter
class MemberPersistenceAdapter(
    private val memberRepository: MemberRepository,
    private val mappingProvider: MappingProvider
) : SaveMemberPort,
    FindMemberPort {

    override fun save(member: MemberModel): MemberModel =
        MemberModelImpl(
            memberRepository.save((member as MemberModelImpl).memberJpaEntity),
            mappingProvider
        )

    override fun findById(id: Long): MemberModel? =
        memberRepository.findById(id)?.run {
            MemberModelImpl(this, mappingProvider)
        }
}