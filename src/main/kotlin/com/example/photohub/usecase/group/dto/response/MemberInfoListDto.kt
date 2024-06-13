package com.example.photohub.usecase.group.dto.response

import com.example.photohub.usecase.group.model.MemberModel

data class MemberInfoListDto(
    val members: List<MemberInfo>
)

data class MemberInfo(
    val id: Long,
    val name: String,
    val nickname: String?
) {
    companion object {
        fun of(model: MemberModel): MemberInfo =
            MemberInfo(
                id = model.getId(),
                name = model.getName(),
                nickname = model.getNickname()
            )
    }
}
