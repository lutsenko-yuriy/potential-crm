package com.iurii.demo.dao

import com.iurii.demo.entity.Employee

interface EmployeeDao {
    fun findAll(): List<Employee>
    fun findById(id: Long): Employee?
    fun save(employee: Employee): Employee
    fun deleteById(id: Long)
}