package com.example.photohub.data.photocard

import com.example.photohub.PersistenceAdapter
import com.example.photohub.data.photocard.repository.PhotoCardRepository
import com.example.photohub.usecase.global.model.MappingProvider
import com.example.photohub.usecase.photocard.model.PhotoCardModel
import com.example.photohub.usecase.photocard.model.impl.PhotoCardModelImpl
import com.example.photohub.usecase.photocard.port.out.persistence.DeletePhotoCardPort
import com.example.photohub.usecase.photocard.port.out.persistence.FindPhotoCardPort
import com.example.photohub.usecase.photocard.port.out.persistence.SavePhotoCardPort
import java.util.*

@PersistenceAdapter
class PhotoCardPersistenceAdapter(
    private val photoCardRepository: PhotoCardRepository,
    private val mappingProvider: MappingProvider
) : SavePhotoCardPort,
    FindPhotoCardPort,
    DeletePhotoCardPort {

    override fun save(photoCardModel: PhotoCardModel): PhotoCardModel {
        return PhotoCardModelImpl(
            photoCardRepository.save(
                (photoCardModel as PhotoCardModelImpl).photoCardJpaEntity
            ),
            mappingProvider
        )
    }

    override fun findById(id: UUID): PhotoCardModel? =
        photoCardRepository.findById(id)?.run {
            PhotoCardModelImpl(
                this,
                mappingProvider
            )
        }

    override fun findAllOrderCreateAtLimit30(): List<PhotoCardModel> =
        photoCardRepository.findAllOrderByCreatedAtDescLimit30().map {
            PhotoCardModelImpl(
                it,
                mappingProvider
            )
        }

    override fun findAllOrderLikeCountLimit30(): List<PhotoCardModel> =
        photoCardRepository.findAllOrderByLikeCountDescLimit30().map {
            PhotoCardModelImpl(
                it,
                mappingProvider
            )
        }

    override fun findAllOrderRandomLimit30(): List<PhotoCardModel> =
        photoCardRepository.findAllRandomLimit30().map {
            PhotoCardModelImpl(
                it,
                mappingProvider
            )
        }

    override fun deleteById(id: UUID) {
        photoCardRepository.deleteById(id)
    }
}