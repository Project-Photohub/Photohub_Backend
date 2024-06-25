package com.example.photohub.usecase.group.model

interface MemberModelFactory {

    fun create(
        name: String,
        nickname: String?,
        groupModel: GroupModel
    ): MemberModel
}