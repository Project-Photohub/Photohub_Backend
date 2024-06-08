package com.example.photohub.usecase.global.model

import com.example.photohub.data.group.repository.GroupRepository
import com.example.photohub.data.group.repository.MemberRepository
import com.example.photohub.data.photocard.repository.PhotoCardRepository

interface RepositoryProvider {

    fun getGroupRepository(): GroupRepository

    fun getMemberRepository(): MemberRepository

    fun getPhotoCardRepository(): PhotoCardRepository
}