package com.example.photohub.usecase.photocard.model.impl

import com.example.photohub.ModelFactory
import com.example.photohub.data.group.entity.GroupJpaEntity
import com.example.photohub.data.group.entity.MemberJpaEntity
import com.example.photohub.data.photocard.entity.PhotoCardJpaEntity
import com.example.photohub.usecase.global.model.RepositoryProvider
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
        group: GroupJpaEntity,
        member: MemberJpaEntity,
        createdAt: LocalDate,
        id: UUID?
    ): PhotoCardModel =
        PhotoCardModelImpl(
            PhotoCardJpaEntity(
                name, image, backImage, likeCount, group, member, createdAt, id
            ),
            repositoryProvider
        )
}