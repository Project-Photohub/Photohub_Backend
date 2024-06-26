package com.example.photohub.usecase.group.port

import com.example.photohub.UseCase
import com.example.photohub.usecase.global.file.port.out.UploadFileToCloudPort
import com.example.photohub.usecase.group.dto.request.CreateGroupRequest
import com.example.photohub.usecase.group.model.GroupModelFactory
import com.example.photohub.usecase.group.port.`in`.CreateGroupUseCase
import com.example.photohub.usecase.group.port.out.persistence.SaveGroupPort

@UseCase
class CreateGroupService(
    private val saveGroupPort: SaveGroupPort,
    private val groupModelFactory: GroupModelFactory,
    private val uploadFileToCloudPort: UploadFileToCloudPort
) : CreateGroupUseCase {

    override fun invoke(req: CreateGroupRequest) {
        val logoUrl = uploadFileToCloudPort(req.logo)

        saveGroupPort.save(
            groupModelFactory.create(
                name = req.name,
                logo = logoUrl
            )
        )
    }
}