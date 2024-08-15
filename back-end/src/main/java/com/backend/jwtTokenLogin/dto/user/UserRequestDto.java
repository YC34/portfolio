package com.backend.jwtTokenLogin.dto.user;


import lombok.Getter;

@Getter
public class UserRequestDto {

    private String email;
    private String password;

    public UserRequestDto() {
    }
}
