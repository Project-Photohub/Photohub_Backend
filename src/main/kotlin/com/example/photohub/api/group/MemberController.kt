package com.example.photohub.api.group

import com.example.photohub.Controller
import com.example.photohub.security.authentication.annotation.RequireRole
import com.example.photohub.security.authentication.vo.Role
import com.example.photohub.usecase.group.dto.request.CreateMemberRequest
import com.example.photohub.usecase.group.dto.response.MemberInfoListDto
import com.example.photohub.usecase.group.port.`in`.CreateMemberUseCase
import com.example.photohub.usecase.group.port.`in`.GetAllMemberFromGroupUseCase
import jakarta.validation.Valid
import jakarta.validation.constraints.Positive
import org.jetbrains.annotations.NotNull
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RequestMapping("/members")
@Controller
class MemberController(
    private val getAllMemberFromGroupUseCase: GetAllMemberFromGroupUseCase,
    private val createMemberUseCase: CreateMemberUseCase
) {

    @GetMapping("/{groupId}")
    fun getGroup(
        @Valid
        @NotNull
        @Positive
        @PathVariable("groupId")
        groupId: Long
    ): MemberInfoListDto =
        getAllMemberFromGroupUseCase(groupId)

    @RequireRole(Role.MANAGER)
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun create(
        @Valid
        @RequestBody
        req: CreateMemberRequest
    ) {
        createMemberUseCase(req)
    }
}