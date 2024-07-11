package com.iurii.demo.rest

import com.iurii.demo.entity.Employee
import com.iurii.demo.service.EmployeeService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class EmployeeRestController(val employeeService: EmployeeService) {

    @GetMapping("/employees")
    fun employees(): List<Employee> {
        return employeeService.findAll()
    }

    @GetMapping("/employees/{id}")
    fun employeeById(@PathVariable id: Long): Employee =
        employeeService.findById(id) ?: throw EmployeeNotFoundException("Employee with id=$id not found")

    @PostMapping("/employees")
    fun addEmployee(@RequestBody employee: Employee): Employee {
        employee.id = 0
        return employeeService.save(employee)
    }

    @PutMapping("/employees")
    fun updateEmployee(@RequestBody employee: Employee): Employee {
        return employeeService.save(employee)
    }

    @DeleteMapping("/employees/{id}")
    fun deleteEmployee(@PathVariable id: Long) {
        employeeService.findById(id)
            ?: throw EmployeeNotFoundException("Employee with id=$id not found. No one to remove.")
        employeeService.deleteById(id)
    }

}