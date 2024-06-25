package com.example.photohub.security.session

import jakarta.servlet.http.HttpServletRequest

interface SessionAuthenticator {

    operator fun invoke(request: HttpServletRequest)
}