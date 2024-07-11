package com.iurii.demo.dao

import com.iurii.demo.entity.Employee
import jakarta.persistence.EntityManager
import org.springframework.stereotype.Repository

@Repository
class EmployeeDaoImpl(val entityManager: EntityManager) : EmployeeDao {

    override fun findAll(): List<Employee> {
        return entityManager.createQuery("FROM Employee", Employee::class.java).resultList
    }

    override fun findById(id: Long): Employee {
        return entityManager.find(Employee::class.java, id)
    }

    override fun save(employee: Employee): Employee {
        return entityManager.merge(employee)
    }

    override fun deleteById(id: Long) {
        val employee = entityManager.find(Employee::class.java, id)
        entityManager.remove(employee)
    }

}