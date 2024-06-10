package com.example.photohub.usecase.group.dto.response

data class GroupMemberInfoListDto(
    val group: List<GroupMemberInfo>
)

data class GroupMemberInfo(
    val group: GroupInfo,
    val members: List<MemberInfo>
)
