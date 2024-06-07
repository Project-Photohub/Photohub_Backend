package com.example.photohub.data.group.repository

import com.example.photohub.data.group.entity.GroupJpaEntity
import org.springframework.data.repository.Repository

@org.springframework.stereotype.Repository
interface GroupRepository : Repository<GroupJpaEntity, Long?> {

    fun findById(id: Long): GroupJpaEntity?

    fun findAll(): List<GroupJpaEntity>
}