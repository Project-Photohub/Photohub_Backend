package com.example.photohub.usecase.user.port.out.persistence

interface ExistUserPort {

    fun existByUserName(username: String): Boolean
}