package com.example.photohub.data.photocard.entity

import com.example.photohub.data.TableNames
import com.example.photohub.data.base.entity.BaseUuidEntity
import com.example.photohub.data.group.entity.GroupJpaEntity
import com.example.photohub.data.group.entity.MemberJpaEntity
import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.*

@Entity(name = TableNames.PHOTO_CARD)
class PhotoCardJpaEntity(
    name: String,
    image: String,
    backImage: String,
    likeCount: Long = 0,
    group: GroupJpaEntity,
    member: MemberJpaEntity,
    createdAt: LocalDateTime = LocalDateTime.now(),
    id: UUID? = null
) : BaseUuidEntity(id) {

    @Column(name = "name", updatable = true, nullable = false)
    var name: String = name
        protected set

    @Column(name = "image", updatable = true, nullable = false)
    var image: String = image
        protected set

    @Column(name = "back_image", updatable = true, nullable = false)
    var backImage: String = backImage
        protected set

    @Column(name = "like_count", updatable = true, nullable = false)
    var likeCount: Long = likeCount
        protected set

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id", updatable = true, nullable = false)
    var group: GroupJpaEntity = group
        protected set

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", updatable = true, nullable = false)
    var member: MemberJpaEntity = member
        protected set

    @Column(name = "created_at", updatable = false, nullable = false)
    var createdAt: LocalDateTime = createdAt
        protected set
}