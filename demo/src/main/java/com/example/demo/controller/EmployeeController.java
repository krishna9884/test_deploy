package com.example.demo.controller;

import com.example.demo.model.Employee;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import java.util.stream.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class EmployeeController {
    
    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }

    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @GetMapping("/abhinay")
    public String abhinay(){
        return "abhinay";
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return Arrays.asList(
            new Employee("Krishna", 50000),
            new Employee("Ravi", 65000),
            new Employee("Anjali", 70000),
            new Employee("Sita", 60000)
        );
    }
    
    @GetMapping("/employees/high-salary")
    public List<Employee> getHighSalaryEmployees() {
        List<Employee> employees = getEmployees();
        return employees.stream()
            .filter(emp -> emp.getSalary() > 60000)
            .collect(Collectors.toList());
    }
}
