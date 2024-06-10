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

    @Query(
        value = "SELECT * " +
                "FROM ${TableNames.PHOTO_CARD} p " +
                "WHERE p.member_id = :memberId",
        nativeQuery = true
    )
    fun findAllByMember(
        @Param("memberId")
        memberId: Long
    ): List<PhotoCardJpaEntity>
}