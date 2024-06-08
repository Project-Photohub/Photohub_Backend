package com.example.photohub.data.photocard.entity

import com.example.photohub.data.TableNames
import com.example.photohub.data.base.entity.BaseUuidEntity
import com.example.photohub.data.group.entity.GroupJpaEntity
import com.example.photohub.data.group.entity.MemberJpaEntity
import com.example.photohub.data.user.entity.UserJpaEntity
import jakarta.persistence.*
import java.time.LocalDate
import java.util.*

@Entity(name = TableNames.PHOTO_CARD)
class PhotoCardJpaEntity(
    name: String,
    image: String,
    backImage: String,
    likeCount: Long = 0,
    group: GroupJpaEntity,
    member: MemberJpaEntity,
    uploader: UserJpaEntity,
    createdAt: LocalDate = LocalDate.now(),
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uploader_id", updatable = false, nullable = false)
    var uploader: UserJpaEntity = uploader
        protected set

    @Column(name = "created_at", updatable = false, nullable = false)
    var createdAt: LocalDate = createdAt
        protected set
}