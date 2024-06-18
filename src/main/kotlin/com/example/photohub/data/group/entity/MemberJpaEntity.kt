package com.example.photohub.data.group.entity

import com.example.photohub.data.TableNames
import com.example.photohub.data.base.entity.BaseLongIdEntity
import com.example.photohub.data.photocard.entity.PhotoCardJpaEntity
import jakarta.persistence.*

@Entity(name = TableNames.MEMBER)
class MemberJpaEntity(
    name: String,
    nickname: String?,
    group: GroupJpaEntity,
    id: Long? = null
) : BaseLongIdEntity(id) {

    @Column(name = "name", updatable = true, nullable = false)
    var name: String = name
        protected set

    @Column(name = "nickname", updatable = true, nullable = true)
    var nickname: String? = nickname
        protected set

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id", updatable = false, nullable = false)
    var group: GroupJpaEntity = group
        protected set

    @OneToMany(targetEntity = PhotoCardJpaEntity::class, mappedBy = "member", cascade = [(CascadeType.ALL)])
    protected var photoCards: List<PhotoCardJpaEntity> = emptyList()
}