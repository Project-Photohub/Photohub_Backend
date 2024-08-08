package com.example.photohub.infra.file

import com.example.photohub.global.Path

object S3BaseUrlJoiner {

    private var baseUrl: String = ""

    fun init(value: String) {
        if (!this.initialized) {
            this.baseUrl = value
            this.initialized = true
        }
    }

    private var initialized = false

    fun join(s3ObjectKey: String): String {
        return Path.join(baseUrl, s3ObjectKey)
    }

    fun detach(s3ObjectUrl: String): String {
        return s3ObjectUrl.removePrefix(baseUrl).removePrefix("/")
    }
}