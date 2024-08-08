package com.example.photohub.usecase.photocard.port.out.persistence

import java.util.*

interface DeletePhotoCardPort {

    fun deleteById(id: UUID)
}