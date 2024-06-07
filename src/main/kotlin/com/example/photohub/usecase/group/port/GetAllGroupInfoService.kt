package com.example.photohub.usecase.group.port

import com.example.photohub.ReadOnlyUseCase
import com.example.photohub.usecase.exception.StatusCodeException
import com.example.photohub.usecase.group.dto.response.GroupInfo
import com.example.photohub.usecase.group.dto.response.GroupInfoListDto
import com.example.photohub.usecase.group.port.`in`.GetAllGroupInfoUseCase
import com.example.photohub.usecase.group.port.out.persistence.FindGroupPort

@ReadOnlyUseCase
class GetAllGroupInfoService(
    private val findGroupPort: FindGroupPort
) : GetAllGroupInfoUseCase {

    override fun invoke(): GroupInfoListDto {

        val groups = findGroupPort.findAllGroup()

        if (groups.isEmpty()) {
            throw StatusCodeException.NO_CONTENT
        }

        return GroupInfoListDto(
            groups.map {
                GroupInfo.of(it)
            }
        )
    }
}