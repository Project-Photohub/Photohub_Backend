package com.example.photohub.api.user

import com.example.photohub.security.authentication.annotation.RequireAuthenticated
import com.example.photohub.usecase.user.dto.response.MyNameResponse
import com.example.photohub.usecase.user.port.`in`.GetMyNameUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/user")
@RestController
class UserController(
    private val getMyNameUseCase: GetMyNameUseCase
) {

    @RequireAuthenticated
    @GetMapping
    fun getMyName(): MyNameResponse = getMyNameUseCase()
}