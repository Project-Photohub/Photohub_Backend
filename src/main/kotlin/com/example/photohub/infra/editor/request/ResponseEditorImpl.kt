package com.example.photohub.infra.editor.request

import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.MediaType

class ResponseEditorImpl(
    val response: HttpServletResponse,
    private val objectMapper: ObjectMapper
) : ResponseEditor {

    init {
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.characterEncoding = Charsets.UTF_8.name()
    }

    override fun status(status: Int): ResponseEditor {
        this.response.status = status

        return this
    }

    override fun contentType(contentType: MediaType): ResponseEditor {
        this.response.contentType = contentType.type

        return this
    }

    override fun contentType(contentType: String): ResponseEditor {
        this.response.contentType = contentType

        return this
    }

    override fun body(any: Any): ResponseEditor {
        this.response.writer.write(
            objectMapper.writeValueAsString(any)
        )

        return this
    }

    override fun end(): HttpServletResponse {
        this.response.writer.flush()

        return this.response
    }
}