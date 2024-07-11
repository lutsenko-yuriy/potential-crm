package com.iurii.demo.rest

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class EmployeeRestExceptionHandler {
    @ExceptionHandler
    fun handleException(ex: EmployeeNotFoundException): ResponseEntity<EmployeeErrorResponse> {
        val errorResponse =
            EmployeeErrorResponse(
                status = HttpStatus.NOT_FOUND.value(),
                message = ex.message,
                timestamp = System.currentTimeMillis()
            )

        return ResponseEntity(errorResponse, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler
    fun handleException(ex: Exception): ResponseEntity<EmployeeErrorResponse> {
        val errorResponse =
            EmployeeErrorResponse(
                status = HttpStatus.BAD_REQUEST.value(),
                message = ex.message,
                timestamp = System.currentTimeMillis()
            )

        return ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST)
    }
}