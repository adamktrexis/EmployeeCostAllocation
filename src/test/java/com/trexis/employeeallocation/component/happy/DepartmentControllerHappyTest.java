package com.trexis.employeeallocation.component.happy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DepartmentControllerHappyTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetDepartmentAllocation_Happy() {
        ResponseEntity<String> response = restTemplate.getForEntity("/api/departments/1/allocation", String.class);
        assertEquals("Department 1's allocation calculated.", response.getBody());
    }
}
