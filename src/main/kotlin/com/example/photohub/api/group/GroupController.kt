package com.example.photohub.api.group

import com.example.photohub.Controller
import com.example.photohub.security.authentication.annotation.RequireRole
import com.example.photohub.security.authentication.vo.Role
import com.example.photohub.usecase.group.dto.request.CreateGroupRequest
import com.example.photohub.usecase.group.dto.response.GroupInfoListDto
import com.example.photohub.usecase.group.dto.response.GroupMemberInfoListDto
import com.example.photohub.usecase.group.port.`in`.CreateGroupUseCase
import com.example.photohub.usecase.group.port.`in`.GetAllGroupInfoUseCase
import com.example.photohub.usecase.group.port.`in`.GetAllGroupMemberInfoUseCase
import jakarta.validation.Valid
import org.jetbrains.annotations.NotNull
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RequestMapping("/groups")
@Controller
class GroupController(
    private val getAllGroupInfoUseCase: GetAllGroupInfoUseCase,
    private val getAllGroupMemberInfoUseCase: GetAllGroupMemberInfoUseCase,
    private val createGroupUseCase: CreateGroupUseCase
) {

    @GetMapping("/all")
    fun getAllGroupInfo(): GroupInfoListDto =
        getAllGroupInfoUseCase()

    @GetMapping("/all/member")
    fun getAllGroupMemberInfo(): GroupMemberInfoListDto =
        getAllGroupMemberInfoUseCase()

    @RequireRole(Role.MANAGER)
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun create(
        @Valid
        @NotNull
        @RequestParam
        name: String,
        @Valid
        @NotNull
        logo: MultipartFile
    ) {
        createGroupUseCase(
            CreateGroupRequest(
                name = name,
                logo = logo
            )
        )
    }
}