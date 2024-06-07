package com.example.photohub.api.group

import com.example.photohub.Controller
import com.example.photohub.usecase.group.port.`in`.GetAllGroupInfoUseCase
import com.example.photohub.usecase.group.dto.response.GroupInfoListDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/groups")
@Controller
class GroupController(
    private val getAllGroupInfoUseCase: GetAllGroupInfoUseCase
) {

    @GetMapping("/all")
    fun getAllGroupInfo(): GroupInfoListDto =
        getAllGroupInfoUseCase()
}