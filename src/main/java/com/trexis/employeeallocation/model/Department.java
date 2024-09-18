package com.trexis.employeeallocation.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;

    // One department can have many employees (including managers)
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Employee> employees = new ArrayList<>();

    public Department() {}

    public Department(Long id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    // Add an employee to the department
    public void addEmployee(Employee employee) {
        employee.setDepartment(this);  // Set this department for the employee
        this.employees.add(employee);  // Add to the employees list
    }
}



