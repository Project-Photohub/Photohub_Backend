package com.example.photohub.usecase.photocard.port.out.persistence

import com.example.photohub.usecase.photocard.model.PhotoCardModel
import java.util.*

interface FindPhotoCardPort {

    fun findById(id: UUID): PhotoCardModel?

    fun findAllOrderLikeCountLimit30(): List<PhotoCardModel>

    fun findAllOrderCreateAtLimit30(): List<PhotoCardModel>

    fun findAllOrderRandomLimit30(): List<PhotoCardModel>
}