package com.solo.devups.dto;

import lombok.Data;

@Data
public class RegisterUserRequest {
    private String username;
    private String password;
}
