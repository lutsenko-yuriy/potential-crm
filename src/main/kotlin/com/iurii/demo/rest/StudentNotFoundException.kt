package com.iurii.demo.rest

class StudentNotFoundException(
    override val message: String? = null,
    override val cause: Throwable? = null
) : RuntimeException(message, cause)