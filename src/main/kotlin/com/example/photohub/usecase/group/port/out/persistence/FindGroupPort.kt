package com.example.photohub.usecase.group.port.out.persistence

import com.example.photohub.usecase.group.model.GroupModel

interface FindGroupPort {

    fun findAllGroup(): List<GroupModel>
}