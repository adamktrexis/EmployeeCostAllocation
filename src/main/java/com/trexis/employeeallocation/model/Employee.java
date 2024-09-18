package com.trexis.employeeallocation.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String role;

    // Many employees report to one manager (self-referencing relationship)
    @ManyToOne
    @JoinColumn(name = "MANAGER_ID")
    private Employee manager;

    // One manager can have many employees reporting to them
    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> reports = new ArrayList<>();

    // Many employees belong to one department
    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_ID")
    private Department department;

    public Employee() {}

    public Employee(Long id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    // Add a report (subordinate) to the manager
    public void addReport(Employee employee) {
        employee.setManager(this);
        this.reports.add(employee);
    }

    // Job role cost logic
    public int getCost() {
        return switch (role) {
            case "Developer" -> 2000;
            case "QA Tester" -> 1000;
            case "Manager" -> 600;
            default -> 0;
        };
    }
}

