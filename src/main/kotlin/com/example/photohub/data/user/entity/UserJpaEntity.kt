package com.example.photohub.data.user.entity

import com.example.photohub.data.TableNames
import com.example.photohub.data.base.entity.BaseLongIdEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import java.time.LocalDate

@Entity(name = TableNames.USER)
class UserJpaEntity(
    name: String,
    username: String,
    password: String,
    createdAt: LocalDate = LocalDate.now(),
    id: Long? = null,
) : BaseLongIdEntity(id) {

    @Column(name = "name", updatable = false, nullable = false)
    var name: String = name
        protected set

    @Column(name = "username", updatable = false, nullable = false)
    var username: String = username
        protected set

    @Column(name = "password", updatable = false, nullable = false)
    var password: String = password
        protected set

    @Column(name = "created_at", updatable = false, nullable = false)
    var createdAt: LocalDate = createdAt
        protected set
}