
package com.trexis.employeeallocation.service;

import com.trexis.employeeallocation.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {

    // Example of manager data, ideally, this will come from a database
    private List<Employee> employees = MockData.getEmployees();

    // Recursively calculate the total cost allocation for a manager and their reports
    public int calculateManagerAllocation(Long managerId) {
        Employee manager = findEmployeeById(managerId);
        if (manager != null) {
            return calculateAllocationRecursive(manager);
        }
        throw new IllegalArgumentException("Invalid manager ID");
    }

    private int calculateAllocationRecursive(Employee manager) {
        int totalCost = manager.getCost();
        for (Employee report : manager.getReports()) {
            totalCost += calculateAllocationRecursive(report); // Recursively add the cost of all reports
        }
        return totalCost;
    }

    public List<Employee> listManagersWithoutReports() {
        return employees.stream()
            .filter(e -> e.getRole().equals("Manager") && e.getReports().isEmpty())
            .toList();
    }

    private Employee findEmployeeById(Long id) {
        return employees.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
    }
}
