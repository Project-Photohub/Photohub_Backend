package com.example.photohub.usecase.group.port

import com.example.photohub.ReadOnlyUseCase
import com.example.photohub.usecase.exception.BusinessException
import com.example.photohub.usecase.group.dto.response.MemberInfo
import com.example.photohub.usecase.group.dto.response.MemberInfoListDto
import com.example.photohub.usecase.group.port.`in`.GetAllMemberFromGroupUseCase
import com.example.photohub.usecase.group.port.out.persistence.FindGroupPort

@ReadOnlyUseCase
class GetAllMemberFromGroupService(
    private val findGroupPort: FindGroupPort
) : GetAllMemberFromGroupUseCase {

    override fun invoke(groupId: Long): MemberInfoListDto {
        val group = findGroupPort.findById(groupId)
            ?: throw BusinessException.GROUP_NOT_FOUND

        return MemberInfoListDto(
            group.getMembers().map {
                MemberInfo.of(it)
            }
        )
    }
}