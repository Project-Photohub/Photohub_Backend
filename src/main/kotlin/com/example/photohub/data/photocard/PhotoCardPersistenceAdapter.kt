package com.example.photohub.data.photocard

import com.example.photohub.PersistenceAdapter
import com.example.photohub.data.photocard.repository.PhotoCardRepository
import com.example.photohub.usecase.global.model.RepositoryProvider
import com.example.photohub.usecase.photocard.model.PhotoCardModel
import com.example.photohub.usecase.photocard.model.impl.PhotoCardModelImpl
import com.example.photohub.usecase.photocard.port.out.persistence.SavePhotoCardPort

@PersistenceAdapter
class PhotoCardPersistenceAdapter(
    private val photoCardRepository: PhotoCardRepository,
    private val repositoryProvider: RepositoryProvider
) : SavePhotoCardPort {

    override fun save(photoCardModel: PhotoCardModel): PhotoCardModel {
        return PhotoCardModelImpl(
            photoCardRepository.save(
                (photoCardModel as PhotoCardModelImpl).photoCardJpaEntity
            ),
            repositoryProvider
        )
    }
}