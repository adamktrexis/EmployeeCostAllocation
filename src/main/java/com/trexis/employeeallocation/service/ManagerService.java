
package com.trexis.employeeallocation.service;

import com.trexis.employeeallocation.model.Employee;
import com.trexis.employeeallocation.repository.EmployeeRepositoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {

    @Autowired
    private EmployeeRepositoryDTO employeeRepositoryDTO;

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
            totalCost += calculateAllocationRecursive(report);
        }
        return totalCost;
    }

    public List<Employee> listManagersWithoutReports() {
        return employeeRepositoryDTO.findAll().stream()
            .filter(e -> e.getRole().equals("Manager") && e.getReports().isEmpty())
            .toList();
    }

    private Employee findEmployeeById(Long id) {
        return employeeRepositoryDTO.findById(id).orElse(null);
    }
}
