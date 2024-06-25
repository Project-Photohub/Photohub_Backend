package com.example.photohub.usecase.group.port

import com.example.photohub.UseCase
import com.example.photohub.usecase.exception.BusinessException
import com.example.photohub.usecase.group.dto.request.CreateMemberRequest
import com.example.photohub.usecase.group.model.MemberModelFactory
import com.example.photohub.usecase.group.port.`in`.CreateMemberUseCase
import com.example.photohub.usecase.group.port.out.persistence.FindGroupPort
import com.example.photohub.usecase.group.port.out.persistence.SaveMemberPort

@UseCase
class CreateMemberService(
    private val saveMemberPort: SaveMemberPort,
    private val findGroupPort: FindGroupPort,
    private val memberModelFactory: MemberModelFactory
) : CreateMemberUseCase {

    override fun invoke(req: CreateMemberRequest) {
        val group = findGroupPort.findById(req.groupId)
            ?: throw BusinessException.GROUP_NOT_FOUND

        saveMemberPort.save(
            memberModelFactory.create(
                name = req.name,
                nickname = req.nickname,
                groupModel = group
            )
        )
    }
}