package com.example.demo.controllers;

import com.example.demo.models.Employee;
import com.example.demo.repositories.EmployeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class SingleEmployeeController {

    private EmployeeRepository employeeRepository = new EmployeeRepository();
/*
    @GetMapping("/singleEmployee")
    public String getSingleEmployee(@RequestParam (name = "empNo") int empNo, Model model){
        ArrayList<Employee> employees = employeeRepository.getAllEmployees();
        int a = 0;

        for (int i = 0; i < employees.size(); i++){
            if (empNo == (employees.get(i).getEmpNo())){
                a = employees.get(i).getEmpNo();
            }
        }
        model.addAttribute("employeeNo", a);
        return "singleEmployee";
    }*/
}
