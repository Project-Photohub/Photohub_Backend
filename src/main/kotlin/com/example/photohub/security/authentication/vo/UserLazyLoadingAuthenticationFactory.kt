package com.example.photohub.security.authentication.vo

interface UserLazyLoadingAuthenticationFactory {

    fun create(username: String): UserLazyLoadableAuthentication
}