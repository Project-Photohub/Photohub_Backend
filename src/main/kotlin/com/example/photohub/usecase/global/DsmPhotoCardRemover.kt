package com.example.photohub.usecase.global

import com.example.photohub.usecase.photocard.model.PhotoCardModel

object DsmPhotoCardRemover {

    private const val STAG_DSM_GROUP_ID = 5L
    private const val PROD_DSM_GROUP_ID = 0L

    fun removeDSMPhotoCard(photoCards: List<PhotoCardModel>): List<PhotoCardModel> {
        return photoCards.filter {
            it.getGroup().getId() != STAG_DSM_GROUP_ID
        }
    }
}