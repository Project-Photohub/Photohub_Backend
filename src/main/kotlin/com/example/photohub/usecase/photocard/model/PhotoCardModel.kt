package com.example.photohub.usecase.photocard.model

import com.example.photohub.usecase.group.model.GroupModel
import com.example.photohub.usecase.group.model.MemberModel
import com.example.photohub.usecase.user.model.UserModel
import java.time.LocalDateTime
import java.util.*

interface PhotoCardModel {

    fun getId(): UUID

    fun getName(): String

    fun getImageUrl(): String

    fun getBackImageUrl(): String

    fun getLikeCount(): Long

    fun getGroup(): GroupModel

    fun getMember(): MemberModel

    fun getUploader(): UserModel

    fun getCreatedAt(): LocalDateTime
}