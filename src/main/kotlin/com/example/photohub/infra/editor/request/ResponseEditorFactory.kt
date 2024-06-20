package com.example.photohub.infra.editor.request

import jakarta.servlet.http.HttpServletResponse

interface ResponseEditorFactory {

    fun create(response: HttpServletResponse): ResponseEditor
}