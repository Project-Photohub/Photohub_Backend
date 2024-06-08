package com.example.photohub.usecase.photocard.model.impl

import com.example.photohub.data.photocard.entity.PhotoCardJpaEntity
import com.example.photohub.usecase.exception.BusinessException
import com.example.photohub.usecase.global.model.RepositoryProvider
import com.example.photohub.usecase.group.model.GroupModel
import com.example.photohub.usecase.group.model.MemberModel
import com.example.photohub.usecase.group.model.impl.GroupModelImpl
import com.example.photohub.usecase.group.model.impl.MemberModelImpl
import com.example.photohub.usecase.photocard.model.PhotoCardModel
import com.example.photohub.usecase.user.model.UserModel
import com.example.photohub.usecase.user.model.impl.UserModelImpl
import java.time.LocalDate
import java.util.*

class PhotoCardModelImpl(
    val photoCardJpaEntity: PhotoCardJpaEntity,
    private val repositoryProvider: RepositoryProvider
) : PhotoCardModel {

    override fun getId(): UUID = photoCardJpaEntity.id
        ?: throw BusinessException.ENTITY_ID_NOT_ASSIGNED_BUT_CALL

    override fun getName(): String = photoCardJpaEntity.name

    override fun getImage(): String = photoCardJpaEntity.image

    override fun getBackImage(): String = photoCardJpaEntity.backImage

    override fun getLikeCount(): Long = photoCardJpaEntity.likeCount

    override fun getGroup(): GroupModel =
        GroupModelImpl(photoCardJpaEntity.group, repositoryProvider)

    override fun getMember(): MemberModel =
        MemberModelImpl(photoCardJpaEntity.member, repositoryProvider)

    override fun getUploader(): UserModel = UserModelImpl(photoCardJpaEntity.uploader)

    override fun getCreatedAt(): LocalDate = photoCardJpaEntity.createdAt
}