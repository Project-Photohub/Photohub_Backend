package com.example.photohub.infra.exception

import com.example.photohub.usecase.exception.StatusCodeException
import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletException
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import java.nio.charset.StandardCharsets

@Component
class ExceptionFilter(
    private val objectMapper: ObjectMapper
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch (e: ServletException) {

            when (e.rootCause) {
                is StatusCodeException -> {
                    writeExceptionResponse(e.cause as StatusCodeException, response)
                }

                else -> {
                    writeExceptionResponse(StatusCodeException(500, e.rootCause.message ?: ""), response)
                }
            }
        }
    }

    private fun writeExceptionResponse(
        exception: StatusCodeException,
        response: HttpServletResponse
    ) {

        if (exception.statusCode > 299) {
            exception.printStackTrace()
        }

        response.writer.write(
            objectMapper.writeValueAsString(
                ExceptionLog(
                    exception.statusCode,
                    exception.message
                )
            )
        )

        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.characterEncoding = StandardCharsets.UTF_8.name()
    }

    data class ExceptionLog(
        val statusCode: Int,
        val message: String
    )
}