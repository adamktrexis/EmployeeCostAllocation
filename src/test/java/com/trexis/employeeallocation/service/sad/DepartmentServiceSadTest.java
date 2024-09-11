
package com.trexis.employeeallocation.service.sad;

import com.trexis.employeeallocation.service.DepartmentService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertThrows;

class DepartmentServiceSadTest {

    @InjectMocks
    private DepartmentService departmentService;

    @Test
    void testCalculateDepartmentAllocation_InvalidDepartmentId() {
        MockitoAnnotations.openMocks(this);

        // Simulate an invalid department ID
        assertThrows(IllegalArgumentException.class, () -> departmentService.calculateDepartmentAllocation(-1L));
    }
}
