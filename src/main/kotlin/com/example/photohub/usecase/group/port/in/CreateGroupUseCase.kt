package com.example.photohub.usecase.group.port.`in`

import com.example.photohub.usecase.group.dto.request.CreateGroupRequest

interface CreateGroupUseCase {

    operator fun invoke(req: CreateGroupRequest)
}