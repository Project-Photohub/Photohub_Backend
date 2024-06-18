package com.example.photohub.usecase.global.model

import com.example.photohub.data.group.repository.MemberRepository
import com.example.photohub.data.photocard.repository.PhotoCardRepository
import com.example.photohub.usecase.group.model.MemberModel
import com.example.photohub.usecase.group.model.impl.MemberModelImpl
import com.example.photohub.usecase.photocard.model.PhotoCardModel
import com.example.photohub.usecase.photocard.model.impl.PhotoCardModelImpl
import org.springframework.stereotype.Component

@Component
class MappingProviderImpl(
    private val memberRepository: MemberRepository,
    private val photoCardRepository: PhotoCardRepository
) : MappingProvider {

    override fun getMembersByGroup(groupId: Long): List<MemberModel> =
        memberRepository.findAllByGroup(groupId).map {
            MemberModelImpl(
                it, this
            )
        }

    override fun getPhotoCardsByMember(memberId: Long): List<PhotoCardModel> =
        photoCardRepository.findAllByMember(memberId).map {
            PhotoCardModelImpl(
                it, this
            )
        }
}