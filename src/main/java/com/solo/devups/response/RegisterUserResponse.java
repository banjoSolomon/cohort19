package com.solo.devups.response;

import lombok.Data;

@Data
public class RegisterUserResponse {
    private String message;
    private Long userId;
    private String username;

}
