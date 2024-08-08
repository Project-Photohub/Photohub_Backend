package com.example.photohub.usecase.group.model

interface GroupModelFactory {

    fun create(
        name: String,
        logoId: String
    ): GroupModel
}