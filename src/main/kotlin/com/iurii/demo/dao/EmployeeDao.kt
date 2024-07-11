package com.iurii.demo.dao

import com.iurii.demo.entity.Employee

interface EmployeeDao {
    fun findAll(): List<Employee>
}