package com.example.photohub.usecase.group.port.`in`

import com.example.photohub.usecase.group.dto.response.GroupInfoListDto

interface GetAllGroupInfoUseCase {

    operator fun invoke(): GroupInfoListDto
}