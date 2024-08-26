package com.solo.devups.service;

import com.solo.devups.dto.RegisterUserRequest;
import com.solo.devups.response.RegisterUserResponse;

public interface UserService {
    RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest);

}
