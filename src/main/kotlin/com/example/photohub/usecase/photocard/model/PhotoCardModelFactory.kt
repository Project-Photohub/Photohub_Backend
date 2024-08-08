package com.example.photohub.usecase.photocard.model

import com.example.photohub.usecase.group.model.MemberModel
import com.example.photohub.usecase.user.model.UserModel

interface PhotoCardModelFactory {

    fun create(
        name: String,
        imageId: String,
        backImageId: String,
        member: MemberModel,
        uploader: UserModel
    ): PhotoCardModel

    fun update(
        name: String? = null,
        imageId: String? = null,
        backImageId: String? = null,
        likeCount: Long? = null,
        origin: PhotoCardModel
    ): PhotoCardModel
}