package com.example.photohub.usecase.photocard.model.impl

import com.example.photohub.ModelFactory
import com.example.photohub.data.group.entity.GroupJpaEntity
import com.example.photohub.data.group.entity.MemberJpaEntity
import com.example.photohub.data.photocard.entity.PhotoCardJpaEntity
import com.example.photohub.usecase.global.model.MappingProvider
import com.example.photohub.usecase.group.model.GroupModel
import com.example.photohub.usecase.group.model.MemberModel
import com.example.photohub.usecase.group.model.impl.GroupModelImpl
import com.example.photohub.usecase.group.model.impl.MemberModelImpl
import com.example.photohub.usecase.photocard.model.PhotoCardModel
import com.example.photohub.usecase.photocard.model.PhotoCardModelFactory
import java.time.LocalDateTime

@ModelFactory
class PhotoCardModelFactoryImpl(
    private val mappingProvider: MappingProvider
) : PhotoCardModelFactory {

    override fun create(
        name: String,
        image: String,
        backImage: String,
        group: GroupModel,
        member: MemberModel,
    ): PhotoCardModel =
        PhotoCardModelImpl(
            PhotoCardJpaEntity(
                name = name,
                image = image,
                backImage = backImage,
                likeCount = 0,
                group = (group as GroupModelImpl).groupJpaEntity,
                member = (member as MemberModelImpl).memberJpaEntity,
                createdAt = LocalDateTime.now()
            ),
            mappingProvider
        )

    override fun update(
        name: String?,
        image: String?,
        backImage: String?,
        likeCount: Long?,
        group: GroupJpaEntity?,
        member: MemberJpaEntity?,
        origin: PhotoCardModel
    ): PhotoCardModel =
        PhotoCardModelImpl(
            PhotoCardJpaEntity(
                name = name ?: origin.getName(),
                image = image ?: origin.getImage(),
                backImage = backImage ?: origin.getBackImage(),
                likeCount = likeCount ?: origin.getLikeCount(),
                group = (origin.getGroup() as GroupModelImpl).groupJpaEntity,
                member = (origin.getMember() as MemberModelImpl).memberJpaEntity,
                createdAt = origin.getCreatedAt(),
                id = origin.getId()
            ),
            mappingProvider
        )
}