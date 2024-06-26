package com.example.photohub.usecase.group.port.out.persistence

import com.example.photohub.usecase.group.model.MemberModel

interface SaveMemberPort {

    fun save(member: MemberModel): MemberModel
}