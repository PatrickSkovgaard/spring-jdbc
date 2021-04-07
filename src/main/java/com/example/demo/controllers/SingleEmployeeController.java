package com.example.demo.controllers;

import com.example.demo.models.Employee;
import com.example.demo.repositories.EmployeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class SingleEmployeeController {

    private EmployeeRepository employeeRepository = new EmployeeRepository();

    @GetMapping("/search-employee")
    public String search(){
        return "employee_form";
    }

    @PostMapping("/searching")
    public String searching(@RequestParam (name= "id") String id, Model model){

        ArrayList<Employee> employees = employeeRepository.getAllEmployees();

        for (int i = 0; i < employees.size(); i++){
            if (employees.get(i).getEmpNo() == Integer.parseInt(id)){
                model.addAttribute("searched_id", employees.get(i));
                break;
            }
        }
        return "single_employee";
    }


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
