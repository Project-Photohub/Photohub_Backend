package com.example.photohub.infra.exception.converter

import com.example.photohub.usecase.exception.StatusCodeException
import jakarta.validation.ConstraintViolationException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ValidationExceptionConverter {

    @ExceptionHandler
    fun handleMethodArgumentNotValidException(ex: MethodArgumentNotValidException) {
        throw StatusCodeException(
            statusCode = 400,
            message = "${ex.parameter} : ${ex.message}",
            cause = ex
        )
    }

    @ExceptionHandler
    fun handleConstraintViolationException(ex: ConstraintViolationException) {
        throw StatusCodeException(
            statusCode = 400,
            message = ex.constraintViolations.map { it.message }.toString(),
            cause = ex
        )
    }
}