package com.trexis.employeeallocation.component;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ManagerControllerComponentTestComponent {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetManagerAllocation() {
        ResponseEntity<String> response = restTemplate.getForEntity("/api/managers/1/allocation", String.class);
        assertEquals("Manager 1's allocation calculated.", response.getBody());
    }

    @Test
    public void testListManagersWithoutReports() {
        ResponseEntity<String> response = restTemplate.getForEntity("/api/managers/no-reports", String.class);
        assertEquals("List of managers without reports", response.getBody());
    }
}
