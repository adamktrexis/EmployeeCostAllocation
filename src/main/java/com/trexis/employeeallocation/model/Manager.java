
package com.trexis.employeeallocation.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Manager extends Employee {

    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Employee> employeesManaged;

    // Removed the redundant 'id' field since it is inherited from Employee
}
