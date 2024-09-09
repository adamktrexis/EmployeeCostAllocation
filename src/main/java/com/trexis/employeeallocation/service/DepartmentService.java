package com.trexis.employeeallocation.service;

import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    // Simple allocation calculation for the department as a whole
    public String calculateDepartmentAllocation(Long id) {
        if (id == 1L) {
            return "$8000"; // Total department allocation
        } else {
            return "Invalid department ID";
        }
    }
}
