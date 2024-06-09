package com.example.photohub.data.photocard.entity

import com.example.photohub.data.TableNames
import com.example.photohub.data.base.entity.BaseLongIdEntity
import com.example.photohub.data.user.entity.UserJpaEntity
import jakarta.persistence.*
import java.time.LocalDateTime

@Deprecated(message = "유저 관련 기능이 제거됨")
@Entity
@Table(
    name = TableNames.PHOTO_CARD_LIKE,
    indexes = [
        Index(
            columnList = "user_id"
        ),
        Index(
            columnList = "photo_card_id"
        )
    ]
)
class PhotoCardLikeJpaEntity(
    user: UserJpaEntity,
    photoCardJpaEntity: PhotoCardJpaEntity,
    createdAt: LocalDateTime = LocalDateTime.now(),
    id: Long? = null
) : BaseLongIdEntity(id) {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", updatable = false, nullable = false)
    var user: UserJpaEntity = user
        protected set

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "photo_card_id", updatable = false, nullable = false)
    var photoCard: PhotoCardJpaEntity = photoCardJpaEntity
        protected set

    @Column(name = "created_at", updatable = false, nullable = false)
    var createdAt: LocalDateTime = createdAt
        protected set
}