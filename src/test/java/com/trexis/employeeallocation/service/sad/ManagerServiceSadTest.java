
package com.trexis.employeeallocation.service.sad;

import com.trexis.employeeallocation.service.ManagerService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ManagerServiceSadTest {

    @InjectMocks
    private ManagerService managerService;

    @Test
    void testCalculateManagerAllocation_InvalidManagerId() {
        MockitoAnnotations.openMocks(this);

        // Simulate an invalid manager ID
        assertThrows(IllegalArgumentException.class, () -> managerService.calculateManagerAllocation(-1L));
    }
}
