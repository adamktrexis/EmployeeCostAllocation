package com.trexis.employeeallocation.service.happy;

import com.trexis.employeeallocation.service.DepartmentService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DepartmentServiceHappyTest {

    private DepartmentService departmentService = new DepartmentService();

    @Test
    public void testCalculateDepartmentAllocation_Happy() {
        Long departmentId = 1L;
        String result = departmentService.calculateDepartmentAllocation(departmentId);
        assertEquals("Department 1's allocation calculated.", result);
    }
}
