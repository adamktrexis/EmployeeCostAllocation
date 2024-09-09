package com.trexis.employeeallocation.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ManagerControllerEdgeCaseTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testInvalidManagerId() {
        ResponseEntity<String> response = this.restTemplate.getForEntity("/api/managers/999/allocation", String.class);

        // Assume the API returns 404 for invalid manager ID
        assertEquals(404, response.getStatusCodeValue(), "Should return 404 for invalid manager ID");
    }
}
