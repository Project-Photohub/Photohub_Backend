package com.example.photohub.data.photocard.repository

import com.example.photohub.data.TableNames
import com.example.photohub.data.photocard.entity.PhotoCardLikeJpaEntity
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.Repository
import org.springframework.data.repository.query.Param

@Deprecated(message = "유저 관련 기능이 제거됨")
@org.springframework.stereotype.Repository
interface PhotoCardLikeRepository : Repository<PhotoCardLikeJpaEntity, Long?> {

    @Query(
        value = "SELECT * " +
                "FROM ${TableNames.PHOTO_CARD_LIKE} p " +
                "WHERE p.photo_card_id = :photoCardId",
        nativeQuery = true
    )
    fun findAllByPhotoCard(
        @Param("photoCardId")
        photoCardId: Long
    ): List<PhotoCardLikeJpaEntity>

    @Query(
        value = "SELECT * " +
                "FROM ${TableNames.PHOTO_CARD_LIKE} p " +
                "WHERE p.user_id = :userId",
        nativeQuery = true
    )
    fun findAllByUser(
        @Param("userId")
        userId: Long
    ): List<PhotoCardLikeJpaEntity>
}