package com.example.photohub.usecase.photocard.model

import com.example.photohub.usecase.group.model.MemberModel

interface PhotoCardModelFactory {

    fun create(
        name: String,
        image: String,
        backImage: String,
        member: MemberModel
    ): PhotoCardModel

    fun update(
        name: String? = null,
        image: String? = null,
        backImage: String? = null,
        likeCount: Long? = null,
        origin: PhotoCardModel
    ): PhotoCardModel
}