package com.example.userlogin.authentication;

import com.example.userlogin.authentication.jwt.JwtAuthenticationFilter;
import com.example.userlogin.authentication.jwt.JwtService;
import com.example.userlogin.users.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

//@Configuration
//@EnableWebSecurity
//public class AppSecurityConfig extends WebSecurityConfiguration {
////    private JwtAuthenticationFilter jwtAuthenticationFilter;
////
////    @Autowired
////    public AppSecurityConfig(JwtService jwtService, UsersService usersService) {
////
////    }
//}
