package com.example.photohub.data.photocard.repository

import com.example.photohub.data.TableNames
import com.example.photohub.data.photocard.entity.PhotoCardJpaEntity
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.Repository
import org.springframework.data.repository.query.Param
import java.util.*

@org.springframework.stereotype.Repository
interface PhotoCardRepository : Repository<PhotoCardJpaEntity, UUID?> {

    fun save(entity: PhotoCardJpaEntity): PhotoCardJpaEntity

    fun findById(id: UUID): PhotoCardJpaEntity?

    @Query(
        value = "SELECT * " +
                "FROM ${TableNames.PHOTO_CARD} p " +
                "ORDER BY p.created_at DESC " +
                "LIMIT 30",
        nativeQuery = true
    )
    fun findAllOrderByCreatedAtDescLimit30(): List<PhotoCardJpaEntity>

    @Query(
        value = "SELECT * " +
                "FROM ${TableNames.PHOTO_CARD} p " +
                "ORDER BY RAND() " +
                "LIMIT 30",
        nativeQuery = true
    )
    fun findAllRandomLimit30(): List<PhotoCardJpaEntity>

    @Query(
        value = "SELECT * " +
                "FROM ${TableNames.PHOTO_CARD} p " +
                "ORDER BY p.like_count DESC " +
                "LIMIT 30",
        nativeQuery = true
    )
    fun findAllOrderByLikeCountDescLimit30(): List<PhotoCardJpaEntity>

    @Query(
        value = "SELECT * " +
                "FROM ${TableNames.PHOTO_CARD} p " +
                "WHERE p.member_id = :memberId " +
                "LIMIT 30",
        nativeQuery = true
    )
    fun findAllByMember(
        @Param("memberId")
        memberId: Long
    ): List<PhotoCardJpaEntity>

    @Query(
        value = "SELECT * " +
                "FROM ${TableNames.PHOTO_CARD} p " +
                "WHERE p.uploader_id = :uploaderId " +
                "LIMIT 30",
        nativeQuery = true
    )
    fun findAllByUploader(
        @Param("uploaderId")
        uploaderId: Long
    ): List<PhotoCardJpaEntity>
}