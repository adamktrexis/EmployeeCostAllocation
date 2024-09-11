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
    private String role;  // Developer, QA Tester, Manager

    // Self-referencing relationship to model manager-employee hierarchy
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employee manager;  // Manager of this employee

    // List of employees that report to this manager
    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> reports = new ArrayList<>();

    public Employee() {}

    public Employee(Long id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    public void addReport(Employee employee) {
        employee.setManager(this);  // Set this employee as the manager
        this.reports.add(employee);  // Add to the reports list
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