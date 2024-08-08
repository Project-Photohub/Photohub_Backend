package com.example.photohub.usecase.group.dto.response

import com.example.photohub.usecase.group.model.GroupModel

data class GroupInfoListDto(
    val list: List<GroupInfo>
)

data class GroupInfo(
    val id: Long,
    val name: String,
    val logo: String
) {
    companion object {
        fun of(model: GroupModel): GroupInfo = GroupInfo(
            id = model.getId(),
            name = model.getName(),
            logo = model.getLogoUrl()
        )
    }
}
