package com.iurii.demo.service

import com.iurii.demo.dao.EmployeeDao
import com.iurii.demo.entity.Employee
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class EmployeeServiceImpl(private val employeeDao: EmployeeDao) : EmployeeService {

    override fun findAll(): List<Employee> {
        return employeeDao.findAll()
    }

    override fun findById(id: Long): Employee? {
        return employeeDao.findById(id)
    }

    @Transactional
    override fun save(employee: Employee): Employee {
        return employeeDao.save(employee)
    }

    @Transactional
    override fun deleteById(id: Long) {
        employeeDao.deleteById(id)
    }

}