package com.example.photohub.usecase.photocard.model.impl

import com.example.photohub.ModelFactory
import com.example.photohub.data.photocard.entity.PhotoCardJpaEntity
import com.example.photohub.usecase.global.model.RepositoryProvider
import com.example.photohub.usecase.group.model.GroupModel
import com.example.photohub.usecase.group.model.MemberModel
import com.example.photohub.usecase.group.model.impl.GroupModelImpl
import com.example.photohub.usecase.group.model.impl.MemberModelImpl
import com.example.photohub.usecase.photocard.model.PhotoCardModel
import com.example.photohub.usecase.photocard.model.PhotoCardModelFactory
import java.time.LocalDate
import java.util.*

@ModelFactory
class PhotoCardModelFactoryImpl(
    private val repositoryProvider: RepositoryProvider
) : PhotoCardModelFactory {

    override fun create(
        name: String,
        image: String,
        backImage: String,
        likeCount: Long,
        group: GroupModel,
        member: MemberModel,
        createdAt: LocalDate,
        id: UUID?
    ): PhotoCardModel =
        PhotoCardModelImpl(
            PhotoCardJpaEntity(
                name = name,
                image = image,
                backImage = backImage,
                likeCount = likeCount,
                group = (group as GroupModelImpl).groupJpaEntity,
                member = (member as MemberModelImpl).memberJpaEntity,
                createdAt = createdAt,
                id = id
            ),
            repositoryProvider
        )
}