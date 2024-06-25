package com.example.photohub.data.user.repository

import com.example.photohub.data.user.entity.UserJpaEntity
import org.springframework.data.repository.Repository
import java.util.*

@org.springframework.stereotype.Repository
interface UserRepository : Repository<UserJpaEntity, UUID?> {

    fun save(user: UserJpaEntity): UserJpaEntity

    fun findByUsername(username: String): UserJpaEntity?

    fun existsByUsername(username: String): Boolean
}