package com.example.photohub.infra.editor.request

import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Component

@Component
class ResponseEditorFactoryImpl(
    private val objectMapper: ObjectMapper
) : ResponseEditorFactory {

    override fun create(response: HttpServletResponse): ResponseEditor {
        return ResponseEditorImpl(
            response, objectMapper
        )
    }
}