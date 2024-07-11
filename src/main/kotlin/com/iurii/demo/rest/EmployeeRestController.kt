package com.iurii.demo.rest

import com.iurii.demo.dao.EmployeeDao
import com.iurii.demo.entity.Employee
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class EmployeeRestController(val employeeDao: EmployeeDao) {

    @GetMapping("/employees")
    fun employees(): List<Employee> {
        return employeeDao.findAll()
    }

}