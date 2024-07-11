package com.iurii.demo.rest

import com.iurii.demo.entity.Employee
import com.iurii.demo.service.EmployeeService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class EmployeeRestController(val employeeService: EmployeeService) {

    @GetMapping("/employees")
    fun employees(): List<Employee> {
        return employeeService.findAll()
    }

    @GetMapping("/employees/{id}")
    fun employeeById(@PathVariable id: Long): Employee =
        employeeService.findById(id) ?: throw EmployeeNotFoundException("Employee with id=$id not found")


}