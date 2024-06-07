package com.example.photohub.usecase.group.port.`in`

import com.example.photohub.usecase.group.dto.response.MemberInfoListDto

interface GetAllMemberFromGroupUseCase {

    operator fun invoke(groupId: Long): MemberInfoListDto
}