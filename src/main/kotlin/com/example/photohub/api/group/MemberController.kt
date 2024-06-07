package com.example.photohub.api.group

import com.example.photohub.Controller
import com.example.photohub.usecase.group.dto.response.MemberInfoListDto
import com.example.photohub.usecase.group.port.`in`.GetAllMemberFromGroupUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/members")
@Controller
class MemberController(
    private val getAllMemberFromGroupUseCase: GetAllMemberFromGroupUseCase
) {

    @GetMapping("/{groupId}")
    fun getGroup(@PathVariable groupId: Long): MemberInfoListDto =
        getAllMemberFromGroupUseCase(groupId)
}