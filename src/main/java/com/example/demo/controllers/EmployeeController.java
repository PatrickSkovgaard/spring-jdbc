package com.example.demo.controllers;

import com.example.demo.models.Employee;
import com.example.demo.repositories.EmployeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class EmployeeController {
    private EmployeeRepository employeeRepo = new EmployeeRepository();

    @GetMapping("/employees")
    @ResponseBody
    public String getAllEmployees(Model model){
        ArrayList<Employee> getAllEmployees = employeeRepo.getAllEmployees();
        model.addAttribute("employees", getAllEmployees);

        return getAllEmployees.toString();

    }
}
