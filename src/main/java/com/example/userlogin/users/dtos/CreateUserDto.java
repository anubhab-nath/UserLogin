package com.example.userlogin.users.dtos;

import lombok.Data;

@Data
public class CreateUserDto {
    private String email;
    private String password;
}
