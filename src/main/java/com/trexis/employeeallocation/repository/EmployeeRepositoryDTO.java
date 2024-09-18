package com.trexis.employeeallocation.repository;

import com.trexis.employeeallocation.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeRepositoryDTO extends JpaRepository<Employee, Long> {

    List<Employee> findByRoleAndDepartmentId(String role, Long departmentId);

}
