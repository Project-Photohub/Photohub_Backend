package com.example.photohub.usecase.user.port.out

import com.example.photohub.usecase.user.model.UserModel

interface GetCurrentUserPort {

    operator fun invoke(): UserModel
}