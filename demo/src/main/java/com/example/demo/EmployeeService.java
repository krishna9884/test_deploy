package com.example.demo;

import com.example.demo.model.Employee;
import java.util.*;
import java.util.stream.*;

public class EmployeeService {
    
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Krishna", 50000),
            new Employee("Ravi", 65000),
            new Employee("Anjali", 70000),
            new Employee("Sita", 60000)
        );

        System.out.println("All Employees:");
        employees.forEach(System.out::println);
        
        System.out.println("\nHigh Salary Employees (>60000):");
        employees.stream()
            .filter(emp -> emp.getSalary() > 60000)
            .forEach(System.out::println);
    }
}