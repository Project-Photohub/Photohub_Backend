package com.example.photohub.usecase.req.usecase

import com.example.photohub.usecase.req.dto.request.CreateAddMemberReqRequest

interface CreateAddMemberRequestUseCase {

    operator fun invoke(req: CreateAddMemberReqRequest)
}