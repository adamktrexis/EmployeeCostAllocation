package com.trexis.employeeallocation.service.sad;

import com.trexis.employeeallocation.service.ManagerService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ManagerServiceSadTest {

    private ManagerService managerService = new ManagerService();

    @Test
    public void testCalculateManagerAllocation_Sad() {
        Long invalidManagerId = -1L;
        assertThrows(IllegalArgumentException.class, () -> {
            managerService.calculateManagerAllocation(invalidManagerId);
        });
    }
}
