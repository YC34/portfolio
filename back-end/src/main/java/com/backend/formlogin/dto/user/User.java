package com.backend.formlogin.dto.user;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class User {

    private Integer uid;
    private String username;
    private String password;
    private UserRole role;
    private LocalDateTime createAt;
    private String deleteYn;
    private String email;

    public User() {

    }
}
