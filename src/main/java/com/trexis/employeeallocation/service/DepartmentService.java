package com.trexis.employeeallocation.service;

import com.trexis.employeeallocation.model.Employee;
import com.trexis.employeeallocation.repository.EmployeeRepositoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private EmployeeRepositoryDTO employeeRepositoryDTO;

    @Autowired
    private ManagerService managerService;

    public int calculateDepartmentAllocation(Long departmentId) {

        List<Employee> managers = findManagersByDepartment(departmentId);
        int totalCost = 0;
        for (Employee manager : managers) {
            totalCost += managerService.calculateManagerAllocation(manager.getId());
        }
        return totalCost;
    }

    private List<Employee> findManagersByDepartment(Long departmentId) {
        return employeeRepositoryDTO.findByRoleAndDepartmentId("Manager", departmentId);
    }
}
