package com.example.photohub.data.group.entity

import com.example.photohub.data.TableNames
import com.example.photohub.data.base.entity.BaseLongIdEntity
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.OneToMany

@Entity(name = TableNames.GROUP)
class GroupJpaEntity(
    name: String,
    logoId: String,
    id: Long? = null
) : BaseLongIdEntity(id) {

    @Column(name = "name", updatable = true, nullable = false)
    var name: String = name
        protected set

    @Column(name = "logo_id", updatable = true, nullable = false)
    var logoId: String = logoId
        protected set

    @OneToMany(targetEntity = MemberJpaEntity::class, mappedBy = "group", cascade = [(CascadeType.ALL)])
    protected var members: List<MemberJpaEntity> = emptyList()
}