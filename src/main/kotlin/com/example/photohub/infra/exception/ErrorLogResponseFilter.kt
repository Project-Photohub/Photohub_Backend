package com.example.photohub.infra.exception

import com.example.photohub.infra.editor.request.ResponseEditorFactory
import com.example.photohub.infra.exception.dto.ErrorLogResponse
import com.example.photohub.usecase.exception.StatusCodeException
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.web.filter.OncePerRequestFilter
import java.time.LocalDateTime
import java.util.*

class ErrorLogResponseFilter(
    private val responseEditorFactory: ResponseEditorFactory
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        chain: FilterChain
    ) {
        try {
            chain.doFilter(request, response)
        } catch (e: StatusCodeException) {

            val errorLogResponse = ErrorLogResponse(
                statusCode = e.statusCode,
                message = e.message,
                errorId = UUID.randomUUID().toString().substring(0, 7),
                timestamp = LocalDateTime.now()
            )

            write(response, errorLogResponse)
        } catch (e: Exception) {

            logger.error("Unknown Exception was caught in ErrorLogResponseFilter", e)

            val errorLogResponse = ErrorLogResponse.INTERNAL_SERVER_ERROR

            write(response, errorLogResponse)
        }
    }

    private fun write(response: HttpServletResponse, errorLogResponse: ErrorLogResponse) {
        logger.warn(
            "[${errorLogResponse.errorId}] ${errorLogResponse.statusCode} : ${errorLogResponse.message}",
        )

        responseEditorFactory.create(response)
            .status(errorLogResponse.statusCode)
            .body(errorLogResponse)
            .end()
    }
}