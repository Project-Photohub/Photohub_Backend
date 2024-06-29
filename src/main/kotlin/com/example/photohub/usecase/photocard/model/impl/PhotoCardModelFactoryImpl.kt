package com.example.photohub.usecase.photocard.model.impl

import com.example.photohub.ModelFactory
import com.example.photohub.data.photocard.entity.PhotoCardJpaEntity
import com.example.photohub.usecase.global.model.MappingProvider
import com.example.photohub.usecase.group.model.MemberModel
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
        member: MemberModel,
    ): PhotoCardModel =
        PhotoCardModelImpl(
            PhotoCardJpaEntity(
                name = name,
                image = image,
                backImage = backImage,
                likeCount = 0,
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
        origin: PhotoCardModel
    ): PhotoCardModel =
        PhotoCardModelImpl(
            PhotoCardJpaEntity(
                name = name ?: origin.getName(),
                image = image ?: origin.getImage(),
                backImage = backImage ?: origin.getBackImage(),
                likeCount = likeCount ?: origin.getLikeCount(),
                member = (origin.getMember() as MemberModelImpl).memberJpaEntity,
                createdAt = origin.getCreatedAt(),
                id = origin.getId()
            ),
            mappingProvider
        )
}