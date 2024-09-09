package com.trexis.employeeallocation.component.sad;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DepartmentControllerSadTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetDepartmentAllocation_Sad() {
        ResponseEntity<String> response = restTemplate.getForEntity("/api/departments/-1/allocation", String.class);
        assertEquals(400, response.getStatusCode()); // assuming bad request for invalid ID
    }
}
