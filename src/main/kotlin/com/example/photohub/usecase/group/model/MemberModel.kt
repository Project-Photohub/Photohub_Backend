package com.example.photohub.usecase.group.model

interface MemberModel {

    fun getId(): Long

    fun getName(): String

    fun getNickname(): String

    fun getGroup(): GroupModel
}