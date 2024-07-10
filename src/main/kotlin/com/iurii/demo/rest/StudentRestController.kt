package com.iurii.demo.rest

import com.iurii.demo.entity.Student
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class StudentRestController {

    @GetMapping("/students")
    fun students(): ResponseEntity<List<Student>> {
        return ResponseEntity.ok(
            listOf(
                Student("Jack", "Michael"),
                Student("John", "Doe"),
                Student("John", "Smith")
            )
        )
    }

}