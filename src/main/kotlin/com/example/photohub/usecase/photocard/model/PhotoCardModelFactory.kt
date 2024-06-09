package com.example.photohub.usecase.photocard.model

import com.example.photohub.data.group.entity.GroupJpaEntity
import com.example.photohub.data.group.entity.MemberJpaEntity
import java.time.LocalDate
import java.util.*

interface PhotoCardModelFactory {

    fun create(
        name: String,
        image: String,
        backImage: String,
        likeCount: Long = 0,
        group: GroupJpaEntity,
        member: MemberJpaEntity,
        createdAt: LocalDate = LocalDate.now(),
        id: UUID? = null
    ): PhotoCardModel
}