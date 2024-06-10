package com.example.photohub.usecase.photocard.port.out.persistence

import com.example.photohub.usecase.photocard.model.PhotoCardModel
import java.util.UUID

interface FindPhotoCardPort {

    fun findById(id: UUID): PhotoCardModel?
}