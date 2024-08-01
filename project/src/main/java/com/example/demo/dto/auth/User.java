package com.example.demo.dto.auth;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class User {


    private Integer id;
    private String username;
    private String password;
    private String auth;
    private Date createAt;
    private char deleteYn;

    public User() {
    }

    public UserRole getAuth() {
        return UserRole.valueOf(auth);
    }

    public void setAuth(UserRole auth) {
        this.auth = auth.name();
    }
}
