package com.iurii.demo.rest

import com.iurii.demo.entity.Employee
import jakarta.annotation.PostConstruct
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class EmployeeRestController {

    val employees = mutableListOf<Employee>()

    @PostConstruct
    fun initStudentsList() {
        employees.addAll(
            listOf(
                Employee("Jack", "Michael"),
                Employee("John", "Doe"),
                Employee("John", "Smith")
            )
        )
    }

    @GetMapping("/students")
    fun students(): List<Employee> {
        return employees
    }

    @GetMapping("/students/{id}")
    fun student(@PathVariable id: Int): Employee {
        if (id !in employees.indices) {
            throw StudentNotFoundException("Student with id $id not found")
        }
        return employees[id]
    }

}