package com.trexis.employeeallocation.component;

import com.trexis.employeeallocation.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AuthControllerComponentTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testRegisterAndLoginUser() {
        User newUser = new User();
        newUser.setUsername("testuser");
        newUser.setPassword("password");

        // Test registration
        ResponseEntity<User> registerResponse = restTemplate.postForEntity("/api/auth/register", newUser, User.class);
        assertNotNull(registerResponse.getBody());

        // Test login
        ResponseEntity<String> loginResponse = restTemplate.postForEntity("/api/auth/login", newUser, String.class);
        assertNotNull(loginResponse.getBody());
    }
}
