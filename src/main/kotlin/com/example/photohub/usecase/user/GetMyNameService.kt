package com.example.photohub.usecase.user

import com.example.photohub.ReadOnlyUseCase
import com.example.photohub.usecase.user.dto.response.MyNameResponse
import com.example.photohub.usecase.user.port.`in`.GetMyNameUseCase
import com.example.photohub.usecase.user.port.out.GetCurrentUserPort

@ReadOnlyUseCase
class GetMyNameService(
    private val getCurrentUserPort: GetCurrentUserPort
) : GetMyNameUseCase {

    override fun invoke(): MyNameResponse {
        val user = getCurrentUserPort()

        return MyNameResponse(
            user.getName()
        )
    }
}