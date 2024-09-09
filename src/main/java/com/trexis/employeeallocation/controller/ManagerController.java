package com.trexis.employeeallocation.controller;

import com.trexis.employeeallocation.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/managers")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @GetMapping("/{id}/allocation")
    public String getManagerAllocation(@PathVariable Long id) {
        return managerService.calculateManagerAllocation(id);
    }

    @GetMapping("/no-reports")
    public String listManagersWithoutReports() {
        return managerService.listManagersWithoutReports();
    }
}
