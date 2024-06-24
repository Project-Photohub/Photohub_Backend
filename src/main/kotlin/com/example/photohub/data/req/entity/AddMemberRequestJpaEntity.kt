package com.example.photohub.data.req.entity

import com.example.photohub.data.TableNames
import com.example.photohub.data.base.entity.BaseLongIdEntity
import com.example.photohub.data.group.entity.GroupJpaEntity
import jakarta.persistence.*

@Entity(name = TableNames.ADD_MEMBER_REQUEST)
class AddMemberRequestJpaEntity(
    group: GroupJpaEntity,
    name: String,
    nickname: String?,
    id: Long? = null
) : BaseLongIdEntity(id) {

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "group_id", referencedColumnName = "id", updatable = false, nullable = false)
    var group: GroupJpaEntity = group

    @Column(name = "name", updatable = false, nullable = false)
    var name: String = name

    @Column(name = "nickname", updatable = false, nullable = true)
    var nickname: String? = nickname
}