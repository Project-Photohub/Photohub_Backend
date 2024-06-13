package com.example.photohub.usecase.group.model

interface MemberModelFactory {

    fun create(
        id: Long? = null,
        name: String,
        nickname: String?,
        groupModel: GroupModel
    ): MemberModel
}