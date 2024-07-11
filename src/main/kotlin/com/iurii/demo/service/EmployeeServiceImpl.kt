package com.iurii.demo.service

import com.iurii.demo.dao.EmployeeDao
import org.springframework.stereotype.Service

@Service
class EmployeeServiceImpl(private val employeeDao: EmployeeDao) : EmployeeService {

    override fun findAll() = employeeDao.findAll()

}