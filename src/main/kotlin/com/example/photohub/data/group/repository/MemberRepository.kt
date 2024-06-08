package com.example.photohub.data.group.repository

import com.example.photohub.data.TableNames
import com.example.photohub.data.group.entity.MemberJpaEntity
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.Repository
import org.springframework.data.repository.query.Param

@org.springframework.stereotype.Repository
interface MemberRepository : Repository<MemberJpaEntity, Long?> {

    fun findById(id: Long): MemberJpaEntity?

    @Query(
        value = "SELECT * " +
                "FROM ${TableNames.MEMBER} m " +
                "WHERE m.group_id = :groupId",
        nativeQuery = true
    )
    fun findAllByGroup(
        @Param("groupId")
        groupId: Long
    ): List<MemberJpaEntity>
}
