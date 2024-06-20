package com.example.photohub.infra.editor.request

import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.MediaType

interface ResponseEditor {

    fun status(status: Int): ResponseEditor

    fun contentType(contentType: MediaType): ResponseEditor

    fun contentType(contentType: String): ResponseEditor

    fun body(any: Any): ResponseEditor

    fun end(): HttpServletResponse
}