package com.example.photohub.usecase.group.model

interface GroupModel {

    fun getId(): Long

    fun getName(): String

    fun getLogo(): String

    fun getMembers(): List<MemberModel>
}