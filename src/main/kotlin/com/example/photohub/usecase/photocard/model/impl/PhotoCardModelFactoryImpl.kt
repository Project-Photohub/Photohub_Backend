package com.example.photohub.usecase.photocard.model.impl

import com.example.photohub.ModelFactory
import com.example.photohub.data.photocard.entity.PhotoCardJpaEntity
import com.example.photohub.usecase.global.model.MappingProvider
import com.example.photohub.usecase.group.model.MemberModel
import com.example.photohub.usecase.group.model.impl.GroupModelImpl
import com.example.photohub.usecase.group.model.impl.MemberModelImpl
import com.example.photohub.usecase.photocard.model.PhotoCardModel
import com.example.photohub.usecase.photocard.model.PhotoCardModelFactory
import com.example.photohub.usecase.user.model.UserModel
import com.example.photohub.usecase.user.model.impl.UserModelImpl
import java.time.LocalDateTime

@ModelFactory
class PhotoCardModelFactoryImpl(
    private val mappingProvider: MappingProvider
) : PhotoCardModelFactory {

    override fun create(
        name: String,
        imageId: String,
        backImageId: String,
        member: MemberModel,
        uploader: UserModel,
    ): PhotoCardModel =
        PhotoCardModelImpl(
            PhotoCardJpaEntity(
                name = name,
                imageId = imageId,
                backImageId = backImageId,
                likeCount = 0,
                group = (member.getGroup() as GroupModelImpl).groupJpaEntity,
                member = (member as MemberModelImpl).memberJpaEntity,
                uploader = (uploader as UserModelImpl).userJpaEntity,
                createdAt = LocalDateTime.now()
            ),
            mappingProvider
        )

    override fun update(
        name: String?,
        imageId: String?,
        backImageId: String?,
        likeCount: Long?,
        origin: PhotoCardModel
    ): PhotoCardModel =
        PhotoCardModelImpl(
            PhotoCardJpaEntity(
                name = name ?: origin.getName(),
                imageId = imageId ?: (origin as PhotoCardModelImpl).photoCardJpaEntity.imageId,
                backImageId = backImageId ?: (origin as PhotoCardModelImpl).photoCardJpaEntity.backImageId,
                likeCount = likeCount ?: origin.getLikeCount(),
                group = (origin.getGroup() as GroupModelImpl).groupJpaEntity,
                member = (origin.getMember() as MemberModelImpl).memberJpaEntity,
                uploader = (origin.getUploader() as UserModelImpl).userJpaEntity,
                createdAt = origin.getCreatedAt(),
                id = origin.getId()
            ),
            mappingProvider
        )
}