package com.iurii.demo.rest

class EmployeeNotFoundException(
    override val message: String? = null,
    override val cause: Throwable? = null
) : RuntimeException(message, cause)