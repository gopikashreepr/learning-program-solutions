package com.example.employeeapp.repository;

import com.example.employeeapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}

@Autowired
private EmployeeRepository employeeRepository;

@GetMapping
public List<Employee> getAllEmployees() {
    return employeeRepository.findAll();
}
