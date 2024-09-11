package com.trexis.employeeallocation.controller;

import com.trexis.employeeallocation.service.ManagerService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ManagerControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Mock
    private ManagerService managerService;

    @InjectMocks
    private ManagerController managerController;

    @Test
    public void testGetManagerAllocation() {
        Long managerId = 1L;
        String expected = "Manager 1's allocation calculated";

        when(managerService.calculateManagerAllocation(managerId)).thenReturn(Integer.valueOf(expected));

        String response = this.restTemplate.getForObject("/api/managers/1/allocation", String.class);

        assertEquals(expected, response, "Manager allocation API failed");
    }
}
