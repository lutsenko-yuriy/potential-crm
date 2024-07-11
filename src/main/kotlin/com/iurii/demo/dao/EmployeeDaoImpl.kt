package com.iurii.demo.dao

import com.iurii.demo.entity.Employee
import jakarta.persistence.EntityManager
import org.springframework.stereotype.Repository

@Repository
class EmployeeDaoImpl(val entityManager: EntityManager) : EmployeeDao {

    override fun findAll(): List<Employee> {
        return entityManager.createQuery("FROM Employee", Employee::class.java).resultList
    }
}