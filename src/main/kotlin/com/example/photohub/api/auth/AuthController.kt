package com.example.photohub.api.auth

import com.example.photohub.security.session.env.SessionEnv
import com.example.photohub.usecase.auth.dto.request.LoginRequest
import com.example.photohub.usecase.auth.dto.request.SignupRequest
import com.example.photohub.usecase.auth.port.`in`.LoginUseCase
import com.example.photohub.usecase.auth.port.`in`.SignupUseCase
import jakarta.servlet.http.Cookie
import jakarta.servlet.http.HttpServletResponse
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RequestMapping("/auth")
@RestController
class AuthController(
    private val signupUseCase: SignupUseCase,
    private val loginUseCase: LoginUseCase
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("signup")
    fun signup(
        @Valid
        @RequestBody
        req: SignupRequest
    ) {
        signupUseCase(req)
    }

    @PostMapping("/login")
    fun login(
        @Valid
        @RequestBody
        req: LoginRequest,
        response: HttpServletResponse
    ) {
        val sessionId = loginUseCase(req).sessionId

        val cookie = Cookie(
            SessionEnv.SESSION_COOKIE_NAME,
            sessionId
        )
        cookie.path = "/*"

        response.addCookie(cookie)
    }
}