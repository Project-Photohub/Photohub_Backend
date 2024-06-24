package com.example.photohub.security.authentication.vo

import com.example.photohub.usecase.user.model.UserModel

class UserLazyLoadingAuthentication(
    val username: String,
    val user: UserModel? = null
) {

    fun isLoaded(): Boolean =
        this.user != null
}