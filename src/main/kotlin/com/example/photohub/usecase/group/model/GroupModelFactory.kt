package com.example.photohub.usecase.group.model

interface GroupModelFactory {

    fun create(
        id: Long? = null,
        name: String,
        logo: String
    ): GroupModel
}