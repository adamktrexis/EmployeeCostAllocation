package com.trexis.employeeallocation.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DepartmentServiceTest {

    private DepartmentService departmentService = new DepartmentService();

    @Test
    public void testCalculateDepartmentAllocation() {
        Long departmentId = 1L;
        String result = String.valueOf(departmentService.calculateDepartmentAllocation(departmentId));
        assertEquals("Department 1's allocation calculated.", result);
    }
}
