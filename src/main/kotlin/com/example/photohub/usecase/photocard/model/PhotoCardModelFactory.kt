package com.example.photohub.usecase.photocard.model

import com.example.photohub.data.group.entity.GroupJpaEntity
import com.example.photohub.data.group.entity.MemberJpaEntity
import com.example.photohub.usecase.group.model.GroupModel
import com.example.photohub.usecase.group.model.MemberModel

interface PhotoCardModelFactory {

    fun create(
        name: String,
        image: String,
        backImage: String,
        group: GroupModel,
        member: MemberModel
    ): PhotoCardModel

    fun update(
        name: String? = null,
        image: String? = null,
        backImage: String? = null,
        likeCount: Long? = null,
        group: GroupJpaEntity? = null,
        member: MemberJpaEntity? = null,
        origin: PhotoCardModel
    ): PhotoCardModel
}