package com.example.photohub.data.photocard.entity

import com.example.photohub.data.TableNames
import com.example.photohub.data.base.entity.BaseUuidEntity
import com.example.photohub.data.group.entity.GroupJpaEntity
import com.example.photohub.data.group.entity.MemberJpaEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import java.time.LocalDate
import java.util.*

@Entity(name = TableNames.PHOTO_CARD)
class PhotoCardJpaEntity(
    name: String,
    group: GroupJpaEntity,
    like: Long = 0,
    memberJpaEntity: MemberJpaEntity,
    createdAt: LocalDate = LocalDate.now(),
    id: UUID? = null
) : BaseUuidEntity(id) {

    @Column(name = "created_at", updatable = false, nullable = false)
    var createdAt: LocalDate = createdAt
        protected set
}