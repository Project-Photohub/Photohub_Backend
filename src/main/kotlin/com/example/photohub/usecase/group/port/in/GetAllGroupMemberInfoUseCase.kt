package com.example.photohub.usecase.group.port.`in`

import com.example.photohub.usecase.group.dto.response.GroupMemberInfoListDto

interface GetAllGroupMemberInfoUseCase {

    operator fun invoke(): GroupMemberInfoListDto
}