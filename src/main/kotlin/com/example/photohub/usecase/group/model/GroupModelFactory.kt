package com.example.photohub.usecase.group.model

interface GroupModelFactory {

    fun create(
        name: String,
        logo: String
    ): GroupModel
}