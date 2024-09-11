package com.trexis.employeeallocation.service;

import com.trexis.employeeallocation.model.User;
import com.trexis.employeeallocation.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public void createUser(String username, String rawPassword) {
        // Encrypt the raw password before saving it
        String encodedPassword = passwordEncoder.encode(rawPassword);

        // Create new User object
        User user = new User(username, encodedPassword);

        // Save user to the database
        userRepository.save(user);
    }
}
