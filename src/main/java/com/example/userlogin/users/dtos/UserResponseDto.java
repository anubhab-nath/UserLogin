package com.example.userlogin.users.dtos;

import lombok.Data;

@Data
public class UserResponseDto {
    private Long userId;
    private String email;
    private String token;
}
