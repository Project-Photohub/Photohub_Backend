package com.example.photohub.usecase.group.model

import com.example.photohub.usecase.photocard.model.PhotoCardModel

interface MemberModel {

    fun getId(): Long

    fun getName(): String

    fun getNickname(): String?

    fun getGroup(): GroupModel

    fun getPhotoCards(): List<PhotoCardModel>
}