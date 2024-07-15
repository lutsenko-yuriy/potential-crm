package com.iurii.demo.service

import com.iurii.demo.dao.EmployeeRepository
import com.iurii.demo.entity.Employee
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class EmployeeServiceImpl(private val employeeRepository: EmployeeRepository) : EmployeeService {

    override fun findAll(): List<Employee> {
        return employeeRepository.findAllByOrderByLastNameAsc()
    }

    override fun findById(id: Long): Employee? {
        return employeeRepository.findById(id).orElse(null)
    }

    @Transactional
    override fun save(employee: Employee): Employee {
        return employeeRepository.save(employee)
    }

    @Transactional
    override fun deleteById(id: Long) {
        employeeRepository.deleteById(id)
    }

}