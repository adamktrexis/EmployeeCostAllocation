package com.trexis.employeeallocation.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ManagerServiceIntegrationTest {

    @Autowired
    private ManagerService managerService;

    @Test
    public void testManagerServiceWithDatabase() {
        Long managerId = 1L;

        // Assume we are testing the actual service interaction with the repository (e.g., finding by ID)
        String result = String.valueOf(managerService.calculateManagerAllocation(managerId));

        assertNotNull(result, "Manager allocation should not be null");
    }
}
