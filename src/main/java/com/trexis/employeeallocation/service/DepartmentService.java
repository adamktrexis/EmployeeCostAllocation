
package com.trexis.employeeallocation.service;

import com.trexis.employeeallocation.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private List<Employee> employees = MockData.getEmployees(); // Sample data

    // Calculate total allocation for a department (sum of all manager allocations)
    public int calculateDepartmentAllocation(Long departmentId) {
        // Assuming a department is identified by its top-level managers
        List<Employee> managers = findManagersByDepartment(departmentId);
        int totalCost = 0;
        for (Employee manager : managers) {
            totalCost += calculateManagerAllocation(manager.getId());
        }
        return totalCost;
    }

    private List<Employee> findManagersByDepartment(Long departmentId) {
        // This would ideally query department information. Here we assume all top-level managers are part of the department
        return employees.stream()
            .filter(e -> e.getRole().equals("Manager"))
            .toList();
    }

    // Uses ManagerService logic
    private int calculateManagerAllocation(Long managerId) {
        ManagerService managerService = new ManagerService();
        return managerService.calculateManagerAllocation(managerId);
    }
}
