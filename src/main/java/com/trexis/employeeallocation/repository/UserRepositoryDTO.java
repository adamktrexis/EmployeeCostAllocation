package com.trexis.employeeallocation.repository;

import com.trexis.employeeallocation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryDTO extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
