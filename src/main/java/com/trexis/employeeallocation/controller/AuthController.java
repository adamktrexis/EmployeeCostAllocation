package com.trexis.employeeallocation.controller;

import com.trexis.employeeallocation.security.JwtUtil;
import com.trexis.employeeallocation.model.AuthenticationRequest;
import com.trexis.employeeallocation.model.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationRequest.getUsername(), authenticationRequest.getPassword()));

            String jwtToken = jwtUtil.generateToken(authenticationRequest.getUsername());

            return new AuthenticationResponse(jwtToken);
        } catch (BadCredentialsException e) {
            throw new Exception("Invalid username or password", e);
        } catch (AuthenticationException e) {
            throw new Exception("Authentication failed", e);
        }
    }
}
