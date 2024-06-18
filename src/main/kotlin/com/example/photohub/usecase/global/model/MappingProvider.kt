package com.example.photohub.usecase.global.model

import com.example.photohub.usecase.group.model.MemberModel
import com.example.photohub.usecase.photocard.model.PhotoCardModel

interface MappingProvider {

    fun getMembersByGroup(groupId: Long): List<MemberModel>

    fun getPhotoCardsByMember(memberId: Long): List<PhotoCardModel>
}