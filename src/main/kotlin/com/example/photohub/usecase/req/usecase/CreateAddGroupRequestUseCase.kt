package com.example.photohub.usecase.req.usecase

import com.example.photohub.usecase.req.dto.request.CreateAddGroupReqRequest

interface CreateAddGroupRequestUseCase {

    operator fun invoke(req: CreateAddGroupReqRequest)
}