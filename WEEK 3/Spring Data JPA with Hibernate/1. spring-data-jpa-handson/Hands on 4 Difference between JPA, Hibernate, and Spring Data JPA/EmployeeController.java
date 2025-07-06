package com.example.employeeapp.controller;

import com.example.employeeapp.model.Employee;
import com.example.employeeapp.service.EmployeeService;
import com.example.employeeapp.service.HibernateEmployeeService;
import com.example.employeeapp.service.JPAEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired private EmployeeService employeeService;
    @Autowired private JPAEmployeeService jpaEmployeeService;
    @Autowired private HibernateEmployeeService hibernateEmployeeService;

    @PostMapping("/spring-data")
    public String createWithSpringData(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return "Saved with Spring Data JPA";
    }

    @PostMapping("/jpa")
    public String createWithJPA(@RequestBody Employee employee) {
        jpaEmployeeService.saveWithJPA(employee);
        return "Saved with JPA EntityManager";
    }

    @PostMapping("/hibernate")
    public String createWithHibernate(@RequestBody Employee employee) {
        hibernateEmployeeService.saveWithHibernate(employee);
        return "Saved with Hibernate Session";
    }
}