package com.trexis.employeeallocation.service;

import com.trexis.employeeallocation.model.User;
import com.trexis.employeeallocation.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    @Test
    public void testCreateUser() {
        String rawPassword = "password";
        String encodedPassword = "encodedPassword";

        // Mocking the encoding and saving process
        when(passwordEncoder.encode(rawPassword)).thenReturn(encodedPassword);

        // Creating a new User object
        User user = new User("testuser", encodedPassword);
        when(userRepository.save(user)).thenReturn(user);

        // Call createUser in UserService
        userService.createUser("testuser", rawPassword);

        // Assert that the user is created and saved
        assertNotNull(user);
    }
}

