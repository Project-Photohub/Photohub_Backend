package com.example.photohub.usecase.group.port

import com.example.photohub.ReadOnlyUseCase
import com.example.photohub.usecase.global.OrderScatter
import com.example.photohub.usecase.group.dto.response.GroupInfo
import com.example.photohub.usecase.group.dto.response.GroupMemberInfo
import com.example.photohub.usecase.group.dto.response.GroupMemberInfoListDto
import com.example.photohub.usecase.group.dto.response.MemberInfo
import com.example.photohub.usecase.group.port.`in`.GetAllGroupMemberInfoUseCase
import com.example.photohub.usecase.group.port.out.persistence.FindGroupPort

@ReadOnlyUseCase
class GetAllGroupMemberInfoService(
    private val findGroupPort: FindGroupPort
) : GetAllGroupMemberInfoUseCase {

    override fun invoke(): GroupMemberInfoListDto =
        GroupMemberInfoListDto(
            OrderScatter(
                findGroupPort.findAllGroup()
            ).map { group ->
                GroupMemberInfo(
                    GroupInfo.of(group),
                    group.getMembers().map { member ->
                        MemberInfo.of(member)
                    }
                )
            }
        )
}