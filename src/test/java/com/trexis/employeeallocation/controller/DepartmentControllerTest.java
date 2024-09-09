package com.trexis.employeeallocation.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DepartmentControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetDepartmentAllocation() {
        ResponseEntity<String> response = this.restTemplate.getForEntity("/api/departments/1/allocation", String.class);

        // Assuming the expected result for a department's allocation is predefined
        assertEquals(200, response.getStatusCode(), "Should return 200 for valid department ID");
        assertEquals("Department 1's allocation calculated", response.getBody(), "Department allocation calculation failed");
    }
}
