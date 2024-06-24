package com.example.photohub.data.req.entity

import com.example.photohub.data.TableNames
import com.example.photohub.data.base.entity.BaseLongIdEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity

@Entity(name = TableNames.ADD_GROUP_REQUEST)
class AddGroupRequestJpaEntity(
    name: String,
    logoUrl: String?,
    id: Long? = null
) : BaseLongIdEntity(id) {

    @Column(name = "name", updatable = false, nullable = false)
    var name: String = name
        protected set

    @Column(name = "logo_url", updatable = false, nullable = false)
    var logoUrl: String? = logoUrl
        protected set
}