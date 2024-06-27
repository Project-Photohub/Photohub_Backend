package com.example.photohub.global

object Path {

    fun join(vararg paths: String): String {
        var result = ""

        paths.forEachIndexed() { index, it ->
            result += "/" + it.removeSuffix("/")
        }

        return result.removePrefix("/")
    }
}