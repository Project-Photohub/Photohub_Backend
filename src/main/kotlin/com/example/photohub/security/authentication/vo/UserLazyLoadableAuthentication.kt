package com.example.photohub.security.authentication.vo

import com.example.photohub.usecase.user.model.UserModel

interface UserLazyLoadableAuthentication {

    fun getUsername(): String

    fun getUser(): UserModel
}