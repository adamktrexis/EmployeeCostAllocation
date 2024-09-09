package com.trexis.employeeallocation.controller;

import com.trexis.employeeallocation.service.ManagerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ManagerControllerComponentTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ManagerService managerService;

    @Test
    public void testGetManagerAllocation() {
        Long managerId = 1L;
        String expected = "Manager 1's allocation calculated";

        ResponseEntity<String> response = this.restTemplate.getForEntity("/api/managers/1/allocation", String.class);

        assertEquals(200, response.getStatusCode());
        assertEquals(expected, response.getBody(), "Manager allocation API failed");
    }
}
