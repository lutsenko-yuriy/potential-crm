package com.iurii.demo.rest

import com.iurii.demo.entity.Student
import jakarta.annotation.PostConstruct
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class StudentRestController {

    val students = mutableListOf<Student>()

    @PostConstruct
    fun initStudentsList() {
        students.addAll(
            listOf(
                Student("Jack", "Michael"),
                Student("John", "Doe"),
                Student("John", "Smith")
            )
        )
    }

    @GetMapping("/students")
    fun students(): List<Student> {
        return students
    }

    @GetMapping("/students/{id}")
    fun student(@PathVariable id: Int): Student {
        if (id !in students.indices) {
            throw StudentNotFoundException("Student with id $id not found")
        }
        return students[id]
    }

    @ExceptionHandler
    fun handleException(ex: StudentNotFoundException): ResponseEntity<StudentErrorResponse> {
        val errorResponse =
            StudentErrorResponse(
                status = HttpStatus.NOT_FOUND.value(),
                message = ex.message,
                timestamp = System.currentTimeMillis()
            )

        return ResponseEntity(errorResponse, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler
    fun handleException(ex: Exception): ResponseEntity<StudentErrorResponse> {
        val errorResponse =
            StudentErrorResponse(
                status = HttpStatus.BAD_REQUEST.value(),
                message = ex.message,
                timestamp = System.currentTimeMillis()
            )

        return ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST)
    }
}