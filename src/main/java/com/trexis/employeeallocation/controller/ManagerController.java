package com.trexis.employeeallocation.controller;

import com.trexis.employeeallocation.model.Employee;
import com.trexis.employeeallocation.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/managers")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @GetMapping("/{id}/allocation")
    public String getManagerAllocation(@PathVariable Long id) {
        int allocation = managerService.calculateManagerAllocation(id);
        return String.valueOf(allocation);  // Convert int to String
    }

    @GetMapping("/no-reports")
    public String listManagersWithoutReports() {
        List<Employee> managersWithoutReports = managerService.listManagersWithoutReports();
        return managersWithoutReports.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(", "));
    }
}
