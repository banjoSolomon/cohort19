package com.solo.devups.service;

import com.solo.devups.dto.LoginRequest;
import com.solo.devups.dto.RegisterUserRequest;
import com.solo.devups.models.User;
import com.solo.devups.repository.UserRepository;
import com.solo.devups.response.LoginResponse;
import com.solo.devups.response.RegisterUserResponse;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest) {
        User user = new User();
        user.setUsername(registerUserRequest.getUsername());
        user.setPassword(registerUserRequest.getPassword());
        userRepository.save(user);
        RegisterUserResponse response = new RegisterUserResponse();
        response.setUserId(user.getId());
        response.setUsername(user.getUsername());
        response.setMessage("User successfully registered");
        return response;
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        User user = findUserById(loginRequest.getUsername());
        if (!user.getPassword().equals(loginRequest.getPassword())) {
            throw new IllegalArgumentException("Invalid Credentials");
        }
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setMessage("User logged in successfully");
        return loginResponse;
    }

    private User findUserById(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) throw new IllegalArgumentException("Invalid Credentials");
        return user;
    }
}
