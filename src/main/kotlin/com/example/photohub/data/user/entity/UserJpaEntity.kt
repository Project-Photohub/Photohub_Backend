package com.example.photohub.data.user.entity

import com.example.photohub.data.TableNames
import com.example.photohub.data.base.entity.BaseLongIdEntity
import com.example.photohub.security.authentication.vo.Role
import jakarta.persistence.Column
import jakarta.persistence.Entity
import java.time.LocalDate

@Entity(name = TableNames.USER)
class UserJpaEntity(
    name: String,
    username: String,
    password: String,
    role: Role,
    createdAt: LocalDate = LocalDate.now(),
    id: Long? = null,
) : BaseLongIdEntity(id) {

    @Column(name = "name", updatable = true, nullable = false)
    var name: String = name
        protected set

    @Column(name = "username", unique = true, updatable = true, nullable = false)
    var username: String = username
        protected set

    @Column(name = "password", updatable = true, nullable = false)
    var password: String = password
        protected set

    @Column(name = "role", updatable = true, nullable = false)
    var role: Role = role
        protected set

    @Column(name = "created_at", updatable = false, nullable = false)
    var createdAt: LocalDate = createdAt
        protected set
}