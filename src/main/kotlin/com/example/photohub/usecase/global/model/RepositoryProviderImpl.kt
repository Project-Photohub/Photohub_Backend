package com.example.photohub.usecase.global.model

import com.example.photohub.data.group.repository.GroupRepository
import com.example.photohub.data.group.repository.MemberRepository
import com.example.photohub.data.photocard.repository.PhotoCardRepository
import org.springframework.stereotype.Component

@Component
class RepositoryProviderImpl(
    private val groupRepository: GroupRepository,
    private val memberRepository: MemberRepository,
    private val photoCardRepository: PhotoCardRepository
) : RepositoryProvider {

    override fun getGroupRepository(): GroupRepository = groupRepository

    override fun getMemberRepository(): MemberRepository = memberRepository

    override fun getPhotoCardRepository(): PhotoCardRepository = photoCardRepository
}