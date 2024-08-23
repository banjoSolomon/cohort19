package com.solo.devups.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class User {
    @Id
    private Long id;
    private String username;
    private String password;
    private LocalDateTime dateRegistered;

}
//h