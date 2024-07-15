package com.iurii.demo.controller

import com.iurii.demo.service.EmployeeService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/employees")
class EmployeeController(val employeeService: EmployeeService) {

    @GetMapping("/list")
    fun listOfEmployees(model: Model): String {
        val employees = employeeService.findAll()
        model.addAttribute("employees", employees)
        return "employees/list"
    }

}