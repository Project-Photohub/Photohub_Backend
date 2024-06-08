package com.example.photohub.data.group

import com.example.photohub.PersistenceAdapter
import com.example.photohub.data.group.repository.MemberRepository
import com.example.photohub.usecase.global.model.RepositoryProvider
import com.example.photohub.usecase.group.model.MemberModel
import com.example.photohub.usecase.group.model.impl.MemberModelImpl
import com.example.photohub.usecase.group.port.out.persistence.FindMemberPort

@PersistenceAdapter
class MemberPersistenceAdapter(
    private val memberRepository: MemberRepository,
    private val repositoryProvider: RepositoryProvider
) : FindMemberPort {

    override fun findById(id: Long): MemberModel? =
        memberRepository.findById(id)?.run {
            MemberModelImpl(this, repositoryProvider)
        }
}