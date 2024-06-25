package com.example.photohub.usecase.user.port.out.persistence

import com.example.photohub.usecase.user.model.UserModel

interface SaveUserPort {

    fun save(user: UserModel): UserModel
}