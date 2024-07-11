package com.iurii.demo.rest

import com.iurii.demo.entity.Student
import jakarta.annotation.PostConstruct
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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

}