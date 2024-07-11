package com.iurii.demo.service

import com.iurii.demo.entity.Employee

interface EmployeeService {
    fun findAll(): List<Employee>
    fun findById(id: Long): Employee
    fun save(employee: Employee): Employee
    fun deleteById(id: Long)
}