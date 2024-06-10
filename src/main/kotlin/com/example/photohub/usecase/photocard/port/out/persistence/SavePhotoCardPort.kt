package com.example.photohub.usecase.photocard.port.out.persistence

import com.example.photohub.usecase.photocard.model.PhotoCardModel

interface SavePhotoCardPort {

    fun save(photoCardModel: PhotoCardModel): PhotoCardModel
}