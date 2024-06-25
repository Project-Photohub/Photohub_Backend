package com.example.photohub.usecase.group.port.`in`

import com.example.photohub.usecase.group.dto.request.CreateMemberRequest

interface CreateMemberUseCase {

    operator fun invoke(req: CreateMemberRequest)
}