package com.trexis.employeeallocation.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ManagerNoReportsControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetManagersWithNoReports() {
        ResponseEntity<String> response = this.restTemplate.getForEntity("/api/managers/no-reports", String.class);

        // Assuming the expected result for the list of managers with no reports
        assertEquals(200, response.getStatusCode(), "Should return 200 for valid request");
        assertEquals("List of managers without reports", response.getBody(), "No reports list generation failed");
    }
}
