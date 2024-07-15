package com.iurii.demo.controller

import com.iurii.demo.entity.Employee
import com.iurii.demo.service.EmployeeService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("/employees")
class EmployeeController(val employeeService: EmployeeService) {

    @GetMapping(value = ["/", "/list"])
    fun listOfEmployees(model: Model): String {
        val employees = employeeService.findAll()
        model.addAttribute("employees", employees)
        return "employees/list"
    }

    @GetMapping("/add")
    fun addEmployee(model: Model): String {
        val employee = Employee()
        model.addAttribute("employee", employee)
        return "employees/add"
    }

    @GetMapping("/update")
    fun updateEmployee(@RequestParam("id") employeeId: Long, model: Model): String {
        val employee = employeeService.findById(employeeId)
        model.addAttribute("employee", employee)
        return "employees/add"
    }

    @PostMapping("/save")
    fun saveEmployee(@ModelAttribute("employee") employee: Employee): String {
        employeeService.save(employee)
        return "redirect:/employees/list"
    }

}