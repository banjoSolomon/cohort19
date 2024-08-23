package com.solo.devups.service;

import com.solo.devups.dto.RegisterUserRequest;
import com.solo.devups.response.RegisterUserResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class RegisterTest {
    @Autowired
    private UserService userService;


    @Test
    public void registerUser() {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setUsername("username");
        registerUserRequest.setPassword("password");
        RegisterUserResponse response = userService.registerUser(registerUserRequest);
        assertNotNull(response);
        assertEquals("username", response.getUsername());
        assertNotNull(response.getUserId());
        assertEquals("User successfully registered", response.getMessage());

    }
}
