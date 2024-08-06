package com.example.photohub.usecase.user.model

import com.example.photohub.security.authentication.vo.Role
import com.example.photohub.usecase.photocard.model.PhotoCardModel

interface UserModel {

    fun getName(): String

    fun getUsername(): String

    fun getPassword(): String

    fun getRole(): Role

    fun getUploadedPhotoCards(): List<PhotoCardModel>
}