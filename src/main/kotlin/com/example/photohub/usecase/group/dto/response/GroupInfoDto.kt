package com.example.photohub.usecase.group.dto.response

import com.example.photohub.usecase.group.model.GroupModel

data class GroupInfoDto(
    val id: Long,
    val name: String,
    val logo: String
) {
    companion object {
        fun of(model: GroupModel): GroupInfoDto = GroupInfoDto(
            id = model.getId(),
            name = model.getName(),
            logo = model.getLogo()
        )
    }
}
