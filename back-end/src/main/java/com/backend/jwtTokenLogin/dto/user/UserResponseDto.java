package com.backend.jwtTokenLogin.dto.user;


import com.backend.jwtTokenLogin.entity.user.UserRole;
import lombok.Getter;

@Getter
public class UserResponseDto {

    private String username;
    private String email;
    private UserRole userRole;
}
