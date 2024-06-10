package com.example.photohub.usecase.photocard.model

import com.example.photohub.usecase.group.model.GroupModel
import com.example.photohub.usecase.group.model.MemberModel
import java.time.LocalDate
import java.util.*

interface PhotoCardModelFactory {

    fun create(
        name: String,
        image: String,
        backImage: String,
        likeCount: Long = 0,
        group: GroupModel,
        member: MemberModel,
        createdAt: LocalDate = LocalDate.now(),
        id: UUID? = null
    ): PhotoCardModel
}