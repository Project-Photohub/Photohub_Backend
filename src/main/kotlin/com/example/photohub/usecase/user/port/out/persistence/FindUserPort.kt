package com.example.photohub.usecase.user.port.out.persistence

import com.example.photohub.usecase.user.model.UserModel

interface FindUserPort {

    fun findByUsername(username: String): UserModel?
}