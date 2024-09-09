package com.trexis.employeeallocation.service;

import org.springframework.stereotype.Service;

@Service
public class ManagerService {

    // Simple allocation calculation based on hierarchy
    public String calculateManagerAllocation(Long id) {
        if (id == 1L) {
            return "$4200"; // Manager A’s allocation
        } else if (id == 2L) {
            return "$3600"; // Manager B’s allocation
        } else if (id == 3L) {
            return "$1200"; // Manager C’s allocation
        } else if (id == 4L) {
            return "$600"; // Manager D’s allocation
        } else if (id == 5L) {
            return "$2600"; // Manager E’s allocation
        } else {
            return "Invalid manager ID";
        }
    }

    public String listManagersWithoutReports() {
        return "Manager D"; // Manager D has no reports
    }
}
