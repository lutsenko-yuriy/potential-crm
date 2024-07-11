package com.iurii.demo.service

import com.iurii.demo.entity.Employee

interface EmployeeService {
    fun findAll(): List<Employee>
}