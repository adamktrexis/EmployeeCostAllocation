package com.trexis.employeeallocation.service.happy;

import com.trexis.employeeallocation.service.ManagerService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManagerServiceHappyTest {

    private ManagerService managerService = new ManagerService();

    @Test
    public void testCalculateManagerAllocation_Happy() {
        Long managerId = 1L;
        String result = String.valueOf(managerService.calculateManagerAllocation(managerId));
        assertEquals("Manager 1's allocation calculated.", result);
    }

    @Test
    public void testListManagersWithoutReports_Happy() {
        String result = managerService.listManagersWithoutReports().toString();
        assertEquals("List of managers without reports", result);
    }
}
