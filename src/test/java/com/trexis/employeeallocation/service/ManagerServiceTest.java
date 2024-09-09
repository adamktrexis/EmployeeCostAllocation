package com.trexis.employeeallocation.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManagerServiceTest {

    private ManagerService managerService = new ManagerService();

    @Test
    public void testCalculateManagerAllocation() {
        Long managerId = 1L;
        String result = managerService.calculateManagerAllocation(managerId);
        assertEquals("Manager 1's allocation calculated.", result);
    }

    @Test
    public void testListManagersWithoutReports() {
        String result = managerService.listManagersWithoutReports();
        assertEquals("List of managers without reports", result);
    }
}
