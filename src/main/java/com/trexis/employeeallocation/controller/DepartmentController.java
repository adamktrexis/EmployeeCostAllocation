package com.trexis.employeeallocation.controller;

import com.trexis.employeeallocation.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/{id}/allocation")
    public String getDepartmentAllocation(@PathVariable Long id) {
        int allocation = departmentService.calculateDepartmentAllocation(id);
        return String.valueOf(allocation);
    }
}

