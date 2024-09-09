package com.trexis.employeeallocation.service.sad;

import com.trexis.employeeallocation.service.DepartmentService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DepartmentServiceSadTest {

    private DepartmentService departmentService = new DepartmentService();

    @Test
    public void testCalculateDepartmentAllocation_Sad() {
        Long invalidDepartmentId = -1L;
        assertThrows(IllegalArgumentException.class, () -> {
            departmentService.calculateDepartmentAllocation(invalidDepartmentId);
        });
    }
}
