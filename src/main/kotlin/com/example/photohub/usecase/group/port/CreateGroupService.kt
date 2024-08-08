package com.example.photohub.usecase.group.port

import com.example.photohub.UseCase
import com.example.photohub.usecase.global.file.port.out.FileUploadPort
import com.example.photohub.usecase.group.dto.request.CreateGroupRequest
import com.example.photohub.usecase.group.model.GroupModelFactory
import com.example.photohub.usecase.group.port.`in`.CreateGroupUseCase
import com.example.photohub.usecase.group.port.out.persistence.SaveGroupPort

@UseCase
class CreateGroupService(
    private val saveGroupPort: SaveGroupPort,
    private val groupModelFactory: GroupModelFactory,
    private val fileUploadPort: FileUploadPort
) : CreateGroupUseCase {

    override fun invoke(req: CreateGroupRequest) {
        val logoId = fileUploadPort.uploadFile(req.logo)

        saveGroupPort.save(
            groupModelFactory.create(
                name = req.name,
                logoId = logoId
            )
        )
    }
}