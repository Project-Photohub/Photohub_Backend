package com.example.photohub.api.group

import com.example.photohub.Controller
import com.example.photohub.security.authentication.annotation.RequireAuthenticated
import com.example.photohub.security.authentication.annotation.RequireRole
import com.example.photohub.security.authentication.vo.Role
import com.example.photohub.usecase.group.dto.response.GroupInfoListDto
import com.example.photohub.usecase.group.dto.response.GroupMemberInfoListDto
import com.example.photohub.usecase.group.port.`in`.GetAllGroupInfoUseCase
import com.example.photohub.usecase.group.port.`in`.GetAllGroupMemberInfoUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/groups")
@Controller
class GroupController(
    private val getAllGroupInfoUseCase: GetAllGroupInfoUseCase,
    private val getAllGroupMemberInfoUseCase: GetAllGroupMemberInfoUseCase
) {

    @RequireAuthenticated
    @GetMapping("/all")
    fun getAllGroupInfo(): GroupInfoListDto =
        getAllGroupInfoUseCase()

    @RequireRole(Role.ADMIN)
    @GetMapping("/all/member")
    fun getAllGroupMemberInfo(): GroupMemberInfoListDto =
        getAllGroupMemberInfoUseCase()
}